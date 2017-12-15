package org.januson.aoc2017.day05

class MazeRunner(
        private val maze: Maze) {

    private var steps = 0

    fun run() {
        while (!maze.outside()) {
            maze.move()
            steps++
        }
    }

    fun steps(): Int {
        return steps
    }
}