import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class TestScheduler {
    @Test
    fun `valid meeting`() {
        val person = Person("Echo")
        val room = Room("mainRoom")
        val scheduler = Scheduler()
        scheduler.schedule("first meeting", person, room)
        assertThat(scheduler.meetings.size).isEqualTo(1)
        scheduler.outputCurrentMeetings()
    }

    @Test
    fun `no room scheduled should not create a meeting`() {
        val person1 = Person("Echo")
        val person2 = Person("Mona")
        val scheduler = Scheduler()
        scheduler.schedule("too many people", person1, person2)
        assertThat(scheduler.meetings.size).isEqualTo(0)
        scheduler.outputCurrentMeetings()
    }
}