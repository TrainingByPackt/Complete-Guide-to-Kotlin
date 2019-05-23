interface Schedulable {
    val name: String
    /**
     * if true it can hold occupants, for example
     * if this is a room. A person class does not have space
     */
    val hasSpaceForOccupants: Boolean
}