package kotlinguide.chapter10.todoapp.model

import java.security.InvalidParameterException
import java.util.concurrent.atomic.AtomicInteger

typealias ItemId = Int

class ThingsToDo {

    private val nextId = AtomicInteger(0)

    private val map = mutableMapOf<ItemId, ThingToDo>()

    operator fun get(id: ItemId): ThingToDo? = map[id]

    fun allActive(): List<ThingToDo> = map.values
        .filter { it.status != ToDoStatus.Canceled }
        .sortedBy { it.priority }

    fun add(toDo: ThingToDo): ItemId =
        validate(toDo).let {
            nextId.incrementAndGet().also {
                map[it] = toDo
            }
        }

    private fun validate(toDo: ThingToDo): ThingToDo =
        if (toDo.priority in (1..10))
            toDo
        else
            throw InvalidParameterException("Priority must be between 1 and 10")


    fun remove(id: ItemId): ThingToDo? = map.remove(id)

    fun replace(id: ItemId, toDo: ThingToDo): ThingToDo? =
        validate(toDo).let {
            map.replace(id, it)
        }

}
