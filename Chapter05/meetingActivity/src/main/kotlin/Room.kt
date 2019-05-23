class Room(override val name: String,
           override val hasSpaceForOccupants: Boolean = true) : Schedulable