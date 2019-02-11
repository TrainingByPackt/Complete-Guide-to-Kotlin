package kotlinguide.chapter10.todoapp

import kotlinguide.chapter10.todoapp.httpadapter.WebServer
import kotlinguide.chapter10.todoapp.model.ThingsToDo


fun main(){
    WebServer(ThingsToDo(), 8080).startAndWait()
}