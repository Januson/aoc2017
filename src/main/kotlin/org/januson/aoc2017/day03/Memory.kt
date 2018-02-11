package org.januson.aoc2017.day03

interface Memory {

    fun locationOf(target: Int): Location

}

interface Grid {

    fun current(): Location

    fun advance()

}

class SpiralGrid : Grid {

    private var x = 0
    private var y = 0
    private var direction = Direction.SOUTH

    override fun advance() {
        if (x == y || (x < 0 && x == -y) || (x > 0 && x == 1 - y)) {
            direction = direction.turn()
        }
        x += direction.x
        y += direction.y
    }

    override fun current() = Location(x, y)
}

class IncrementingMemory(
        private val grid: Grid) : Memory {

    private var current: Int = 1

    override fun locationOf(target: Int): Location {
        while (current != target) {
            current = next()
            grid.advance()
        }
        return grid.current()
    }

    private fun next(): Int {
        return current + 1
    }
}

class SpiralMemory(private val sequence: Sequence) : Memory {

    override fun locationOf(target: Int): Location {
        var x = 0
        var y = 0
        var direction = Direction.SOUTH
        while (true) {
            val next = sequence.next()
            if (next == target) {
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
