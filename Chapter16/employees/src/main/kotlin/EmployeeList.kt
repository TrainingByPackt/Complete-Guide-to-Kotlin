import mu.KotlinLogging
import org.apache.commons.math3.stat.StatUtils

class EmployeeList {
    private val logger = KotlinLogging.logger {}

    fun describe() {
        val avg = StatUtils.geometricMean(doubleArrayOf(1.0, 2.0))
        logger.debug { "hello the average is $avg" }

    }
}