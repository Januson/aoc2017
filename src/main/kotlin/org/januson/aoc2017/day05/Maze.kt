package org.januson.aoc2017.day05

class Maze(private val instructions: List<Instruction>) {

    private var location = 0

    fun move() {
        if (outside()) {
            return
        }
        location += instructions[location].offset()
    }

    fun outside(): Boolean {
        return location < 0 || location >= instructions.size
    }
}