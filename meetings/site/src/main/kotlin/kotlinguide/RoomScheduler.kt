import kotlinguide.model.Meeting
import kotlinguide.model.MeetingRoom
import java.util.Date

class RoomScheduler {
    private var meeting: Meeting? = null

    private var room: MeetingRoom = MeetingRoom("1", "Home")

    fun scheduledFor(start: Date, end: Date): Boolean {
        return meeting?.let {
            it.start?.after(start) == true && it.start?.before(end) == true
        } ?: false
    }
}