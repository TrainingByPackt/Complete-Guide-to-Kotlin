class Scheduler(val meetings: MutableList<Meeting> = mutableListOf()) {
    fun schedule(name: String, vararg attendees: Schedulable) {
        val thereIsARoom = attendees.filter { it.hasSpaceForOccupants }.isNotEmpty()

        if (thereIsARoom) {
            meetings.add(Meeting(name, attendees.toList()))
        }
    }

    fun outputCurrentMeetings() {
        meetings.forEach {
            println("meeting ${it.name} ${it.attendingDescription()}")
        }
    }
}