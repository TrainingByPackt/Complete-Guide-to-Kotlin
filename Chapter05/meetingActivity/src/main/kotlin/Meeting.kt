class Meeting(val name: String, private val attending: List<Schedulable>) {
    fun attendingDescription() : String =
        attending.fold("", { total, next -> "$total ${next.name}, "})
}