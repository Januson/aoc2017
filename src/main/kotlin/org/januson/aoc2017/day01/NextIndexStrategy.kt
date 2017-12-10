package org.januson.aoc2017.day01

interface NextIndexStrategy {

    fun get(index: Int): Int

}

class CircularNextIndex(private val size: Int) : NextIndexStrategy {

    override fun get(index: Int): Int {
        val nextIndex = index + 1
        if (nextIndex < size) {
            return nextIndex
        }
        return 0
    }

}

class HalfwayNextIndex(private val size: Int) : NextIndexStrategy {

    override fun get(index: Int): Int {
        return (index + size / 2) % size
    }

}