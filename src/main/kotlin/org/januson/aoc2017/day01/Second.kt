package org.januson.aoc2017.day01

import java.io.File


fun main(args: Array<String>) {
    val data = parseData()
    val list = CircularList(
            HalfwayNextIndex(data.size),
            data
    )
    val captcha = Captcha(list)
    println(captcha.solution()) // 1292
}

private fun parseData(): List<Int> {
    return File("src/main/resources/day01/second.txt")
            .readLines()
            .map { it.toCharArray() }
            .flatMap { it.asList() }
            .map { it.toString() }
            .map { it.toInt() }
}