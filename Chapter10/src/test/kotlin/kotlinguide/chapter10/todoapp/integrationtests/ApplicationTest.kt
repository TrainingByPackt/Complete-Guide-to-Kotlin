package kotlinguide.chapter10.todoapp.integrationtests

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import assertk.assertions.startsWith
import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.client.response.readText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinguide.chapter10.todoapp.httpadapter.WebServer
import kotlinguide.chapter10.todoapp.model.ThingToDo
import kotlinguide.chapter10.todoapp.model.ThingsToDo
import kotlinguide.chapter10.todoapp.model.ToDoStatus.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.net.URL

class ApplicationTest {

    var TEST_URL="http://localhost:7171/thingstodo/"

    val client = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = GsonSerializer() //set automatic Json serializer
        }
    }

    @Test
    fun `start and create one todo item`(){

        val todoItem = ThingToDo("Run integration tests", 1, InProgress)

        WebServer(ThingsToDo(), 7171)
            .startAndContinue()
            .use {

                runBlocking {

                    val items = client.call(TEST_URL).response.readText()

                    assertThat(items).isEqualTo("[]")


                    val newItemId = client.post<String> {
                        url(URL(TEST_URL))
                        contentType(ContentType.Application.Json)
                        body = todoItem
                    }

                    assertThat(newItemId).isEqualTo("Added with id 1")

                    val newItem = client.get<ThingToDo>(TEST_URL + "1")

                    assertThat(newItem).isEqualTo(todoItem)

                }
            }
    }



    @Test
    fun `delete and modify items`(){

        val itemsList = ThingsToDo().apply {
                add(ThingToDo("Learn Kotlin", 1, Done))
                add(ThingToDo("Write Application", 3, InProgress))
                add(ThingToDo("Make Money", 5, NotStarted))
            }
        WebServer(itemsList, 7171)
            .startAndContinue()
            .use {

            runBlocking {

                val items = client.get<Array<ThingToDo>>(TEST_URL)

                assertThat(items).hasSize(3)


                val deleted = client.delete<String>(TEST_URL +"1")


                assertThat(deleted).startsWith("Removed")

                val newItem = ThingToDo("Help the world", 5, NotStarted)

                val putMsg = client.put<String> {
                    url(URL(TEST_URL + "3"))
                    contentType(ContentType.Application.Json)
                    body = newItem
                }

                assertThat(putMsg).startsWith("Replaced old value")

                val editedItem = client.get<ThingToDo>(TEST_URL +"3")

                assertThat(editedItem.description).isEqualTo("Help the world")

            }
        }

    }


}