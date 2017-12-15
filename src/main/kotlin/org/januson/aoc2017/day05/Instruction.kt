package org.januson.aoc2017.day05

class Instruction(
        private var offset: Int,
        private val behaviour: Behaviour) {

    fun offset(): Int {
        val currentOffset = offset
        offset = behaviour.behave(offset)
        return currentOffset
    }

    interface Behaviour {
        fun behave(offset: Int): Int
    }
}