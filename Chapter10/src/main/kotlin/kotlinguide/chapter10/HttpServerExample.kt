package kotlinguide.chapter10

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {

    //create the server using Netty and the port 8080
    val server = embeddedServer(Netty, port = 8080) {

        routing {

            //define first route on GET
            get("/") {
                call.respondText("Hello Kotlin!", ContentType.Text.Plain)
            }

            //define a second route on GET
            get("/author") {
                call.respondText("YourName", ContentType.Text.Plain)
            }

        }

    }

    server.start(wait = true)

}