package kotlinguide.chapter10.todoapp.model

data class ThingToDo(val description: String, val priority: Int, val status: ToDoStatus)

enum class ToDoStatus {
    NotStarted, InProgress, Done, Canceled, Paused
}
