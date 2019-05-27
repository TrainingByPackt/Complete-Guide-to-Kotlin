package builder

import org.junit.jupiter.api.Test
import structure.MenuBuilder
import structure.DishBuilder.Size.small

class StructuredTest {
    @Test
    fun `create single section menu`() {
        val builder = MenuBuilder("Sunshine")
        builder.create {
            // lambda
            dish("pizza") {
                add("cheese")
                add("pepperoni")
                add("mushroom")
                // assignment with enum and static import
                size = small
            }
            // using operator
            dish("veggie pizza") {
                +"mushroom"
                +"onion"
                +"peppers"
            }
            // using properties
            dish("blt") {
                bacon
                lettuce
                tomato
            }
            // extension function
            "tofu scramble".has {
                +"tofu"
                +"avocado"
                +"tomato"
            }
        }
    }

    @Test
    fun `create menu with sections`() {
        val builder = MenuBuilder("Sunshine")
//        builder {
//            section {
//                name = "breakfast"
//                "tofu scramble".has {
//                    +"tofu"
//                    +"avocado"
//                    +"tomato"
//                }
//            }
//
//            section {
//                name = "lunch"
//                // using operator
//                dish("veggie pizza") {
//                    +"mushroom"
//                    +"onion"
//                    +"peppers"
//                }
//                // using properties
//                dish("blt") {
//                    bacon
//                    lettuce
//                    tomato
//                }
//            }
//        }
    }


}