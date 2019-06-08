package ui

import birthday.BirthdayCalculator
import tornadofx.View
import tornadofx.label
import tornadofx.vbox

class BirthdayView : View() {
    override val root = vbox {
        val calc = BirthdayCalculator(1975, 12, 20)
        val info = calc.allInfo()
        label(info)
    }
}
