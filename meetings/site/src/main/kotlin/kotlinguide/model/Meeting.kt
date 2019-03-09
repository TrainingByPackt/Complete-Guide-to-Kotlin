package kotlinguide.model

import java.util.*

class Meeting(val room: MeetingRoom) {
    var start: Date? = null
    var end: Date? = null
}