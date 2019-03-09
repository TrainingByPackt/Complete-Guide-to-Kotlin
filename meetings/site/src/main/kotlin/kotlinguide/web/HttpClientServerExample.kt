package kotlinguide.chapter10

import io.ktor.application.*
import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.engine.apache.Apache
import io.ktor.client.response.readText
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit


fun main() {

    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello World!", ContentType.Text.Plain)
            }
            get("/author") {
                call.respondText("Uberto Barbini")
            }
        }
    }
    server.start(wait = true)

     runBlocking {
        val client = HttpClient(Apache)

        // Get the content of an URL.
        val text = client.call("http://127.0.0.1:8080/author").response.readText() // Suspension point.

        println(text)
    }

    server.stop(gracePeriod = 1, timeout = 10, timeUnit = TimeUnit.SECONDS)
}