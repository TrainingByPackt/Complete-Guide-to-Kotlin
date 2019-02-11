package kotlinguide.chapter10

import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.delete
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import kotlinx.coroutines.runBlocking


    fun main() {

        // Create the client
        val client = HttpClient(Apache)
        runBlocking {

            //     Retrieve the content
            val text = client.call("http://google.com").response.readText()
            println("get $text")

            val resp: HttpResponse = client.delete(host = "www.google.com/")
            println("delete response ${resp.status} ${resp.readText()}")
        }
    }