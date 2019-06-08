package birthday

import org.joda.time.DateTime
import org.joda.time.Days
import java.time.DayOfWeek

class BirthdayCalculator(birthYear: Int, birthMonth: Int, birthDayOfMonth: Int) {
    private val birthDay: DateTime

    init {
        birthDay = DateTime(birthYear, birthMonth, birthDayOfMonth, 0, 0, 0)
    }

    fun daysUntil(): Int {
        val now = DateTime()
        val birthdayThisYear = DateTime(now.year, birthDay.monthOfYear, birthDay.dayOfMonth, 0, 0, 0)
        var untilBirthday = Days.daysBetween(now, birthdayThisYear)
        if (untilBirthday.days < 0) {
            val birthdayNextYear = DateTime(now.year + 1, birthDay.monthOfYear, birthDay.dayOfMonth, 0, 0, 0)
            untilBirthday = Days.daysBetween(now, birthdayNextYear)
        }
        return untilBirthday.days
    }

    fun dayOfTheWeek(): String = DayOfWeek.of(birthDay.dayOfWeek().get()).name

    fun age(): Int = DateTime().year - birthDay.year
}