package kotlinguide.chapter10.todoapp.httpadapter

import io.ktor.application.ApplicationCall
import kotlinguide.chapter10.todoapp.model.ThingToDo
import kotlinguide.chapter10.todoapp.model.ThingsToDo
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.util.pipeline.PipelineContext
import java.util.concurrent.TimeUnit

class WebServer(val thingsToDo: ThingsToDo, val port: Int): AutoCloseable {

    val server by lazy { createServer() }

    private fun createServer(): ApplicationEngine =
        embeddedServer(Netty, port = port) {

            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }

            routing {
                route("thingstodo") {
                    post {
                        val toDo = call.receive<ThingToDo>()
                        val id = thingsToDo.add(toDo)
                        call.respond("Added with id $id")
                    }
                    delete("{id}") {
                        val removed = thingsToDo.remove(id())
                        call.respond("Removed ${removed}")
                    }
                    get("{id}") {
                        val item = thingsToDo[id()]

                        if (item != null) {
                            call.respond(item)
                        } else {
                            call.respond(HttpStatusCode.NotFound, "item not found!")
                        }
                    }
                    put("{id}") {
                        val toDo = call.receive<ThingToDo>()
                        val item = thingsToDo.replace(id(), toDo)

                        call.respond("Replaced old value $item")
                    }
                    get {
                        call.respond(thingsToDo.allActive());
                    }
                }
            }
        }

    private fun PipelineContext<Unit, ApplicationCall>.id() =
        call.parameters["id"]?.toIntOrNull()?:-1


    fun startAndWait() {
        server.start(wait = true)
    }

    fun startAndContinue(): WebServer {
        server.start(wait = false)
        return this
    }

    override fun close() {
        server.stop(1, 2, TimeUnit.SECONDS)
    }


}