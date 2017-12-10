package org.januson.aoc2017.day03

fun main(args: Array<String>) {
    val sequence = Sequence()
    val value = 277678
    val result = SpiralMemory(sequence).locationOf(value)
    val distance = Distance(result)
    println(distance.value)
}