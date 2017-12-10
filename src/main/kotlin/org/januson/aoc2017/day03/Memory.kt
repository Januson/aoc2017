package org.januson.aoc2017.day03

interface Memory {

    fun locationOf(value: Int): Location

}

class SpiralMemory(private val sequence: Sequence) : Memory {

    override fun locationOf(value: Int): Location {
        var x = 0
        var y = 0
        var direction = Direction.SOUTH
        while (true) {
            val next = sequence.next()
            if (next == value) {
                return Location(x, y)
            }
            if (x == y || (x < 0 && x == -y) || (x > 0 && x == 1 - y)) {
                direction = direction.turn()
            }
            x += direction.x
            y += direction.y
        }
    }

}

class Sequence {

    private var value: Int = 1

    fun next(): Int {
        return value++
    }
}

enum class Direction(val x: Int, val y: Int) {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    fun turn(): Direction {
        return when (this) {
            Direction.NORTH -> WEST
            Direction.EAST -> NORTH
            Direction.SOUTH -> EAST
            Direction.WEST -> SOUTH
        }
    }
}

data class Location(val x: Int, val y: Int)
