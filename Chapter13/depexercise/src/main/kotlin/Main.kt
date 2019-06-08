import org.joda.time.DateTime
import org.joda.time.Days

fun main() {
    val now = DateTime()
    val birthdayThisYear = DateTime(now.year, 12, 20, 0, 0, 0)
    var untilBirthday = Days.daysBetween(now, birthdayThisYear)
    if (untilBirthday.days < 0) {
        val birthdayNextYear = DateTime(now.year + 1, 12, 20, 0, 0, 0)
        untilBirthday = Days.daysBetween(now, birthdayNextYear)
    }
    println("days until your birthday: ${untilBirthday.days}")
}
