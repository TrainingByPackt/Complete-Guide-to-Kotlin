package kotlinguide.chapter10.todoapp.model

import assertk.*
import assertk.assertions.hasSize
import assertk.assertions.isEmpty
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test

internal class ToDoItemsTest{

    val items = ThingsToDo()
    val i4 = items.add(
        ThingToDo(
            "ignore the test",
            4,
            ToDoStatus.Canceled
        )
    )
    val i1 = items.add(
        ThingToDo(
            "run the tests",
            1,
            ToDoStatus.Done
        )
    )
    val i3 = items.add(
        ThingToDo(
            "refactor",
            3,
            ToDoStatus.NotStarted
        )
    )
    val i2 = items.add(
        ThingToDo(
            "make it green",
            2,
            ToDoStatus.InProgress
        )
    )


    @Test
    fun `at start is empty`(){
        val emtpyItems = ThingsToDo()

        assertThat(emtpyItems.allActive()).isEmpty()
    }

    @Test
    fun `adds and retrieves TODO items`(){
        items.apply {

            assertThat(get(i1)?.description).isEqualTo("run the tests")
            assertThat(get(i2)?.priority).isEqualTo(2)
            assertThat(get(i3)?.status).isEqualTo(ToDoStatus.NotStarted)
            assertThat(get(i4)?.status).isEqualTo(ToDoStatus.Canceled)

        }
    }

    @Test
    fun `retrieves all non-cancelled items`(){
        items.apply {

            val active = allActive()
            assertThat(active).all{
                hasSize(3)
                isEqualTo(listOf(get(i1), get(i2), get(i3)))
            }

        }
    }


    @Test
    fun `deletes TODO items`(){
        items.apply {
            remove(i1)
            assertThat(allActive()).hasSize(2)
            assertThat(get(i1)).isNull()
        }
    }

    val newItem = ThingToDo(
        "new",
        9,
        ToDoStatus.NotStarted
    )

    @Test
    fun `replaces TODO items`(){
        items.apply {
            val old = replace(i2, newItem)
            assertThat(old?.priority).isEqualTo(2)
            assertThat(get(i2)).isEqualTo(newItem)
        }
    }

    @Test
    fun `doesn't replace TODO items if they don't exist`(){
        items.apply {
            val old = replace(100, newItem)
            assertThat(old).isNull()
            assertThat(get(100)).isNull()
        }
    }

    @Test
    fun `verifies items when adding them`(){
        val e = kotlin.runCatching {
            items.add(ThingToDo("bad", 99, ToDoStatus.NotStarted))
        }.exceptionOrNull()

        assertThat(e?.message).isEqualTo("Priority must be between 1 and 10")
    }


}