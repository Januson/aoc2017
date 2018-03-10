package org.januson.aoc2017.day15

class Value(val value: Long) {

    private val divisor = 2147483647L

    fun next(factor: Long): Value {
        return Value((value * factor) % divisor)
    }

    fun sameAs(other: Value): Boolean {
        return judged() == other.judged()
    }

    fun divisibleBy(number: Int): Boolean {
        return value % number == 0L
    }

    private fun judged(): String {
        val binary = value.toString(BINARY)
        val zeroes = "0".repeat(32 - binary.length)
        val prefixed = zeroes + binary
        return prefixed.substring(prefixed.length - 16)
    }

    private companion object {
        private const val BINARY = 2
    }

}