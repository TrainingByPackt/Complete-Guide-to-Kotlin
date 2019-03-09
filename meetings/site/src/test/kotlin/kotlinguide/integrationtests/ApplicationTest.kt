package kotlinguide.integrationtests

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

}