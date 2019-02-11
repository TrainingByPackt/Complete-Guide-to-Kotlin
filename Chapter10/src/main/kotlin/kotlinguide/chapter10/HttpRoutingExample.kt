package kotlinguide.chapter10

import io.ktor.http.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main(args: Array<String>) {

    val server = embeddedServer(Netty, port = 8080) {
        routing {
            route("site") {
                route("login") {} //all pages for login/password
                route("product") {
                    route("categories") {
                        accept(ContentType.Application.Xml) {
                            get(){} //return categories as xml
                        }
                        accept(ContentType.Text.Html) {
                            get(){} //return categories html page
                        }
                    } // list of products categories
                    get("details/{id}") {} // details of single product
                }
                route("checkout") {
                    get() {} // show checkout page
                    post() {} // get checkout form from user
                }
            }
        }
    }
    server.start(wait = true)

}