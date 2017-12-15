package org.januson.aoc2017.day05

import java.io.File

fun main(args: Array<String>) {
    val expected = 376976
    val behaviour = ALittleStrangeBehaviour()
    val data = File("src/main/resources/day05/first.txt")
            .readLines()
            .map { it.toInt() }
            .map { Instruction(it, behaviour) }
    val maze = Maze(data)
    val runner = MazeRunner(maze)
    runner.run()
    println("Runned steps: ${runner.steps()} expected: $expected")
}
