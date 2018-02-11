package org.januson.aoc2017.day03

fun main(args: Array<String>) {
    first()
    second()
}

private fun first() {
    val sequence = Sequence()
    val value = 277678
    val result = SpiralMemory(sequence).locationOf(value)
    val distance = Distance(result)
    println(distance.value == 475)
}

private fun second() {
    val target = 277678
    val grid = SpiralGrid()
    val memory = IncrementingMemory(grid)
    val location = memory.locationOf(target)
    val distance = Distance(location)
    println(distance.value == 475)
}