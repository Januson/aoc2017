package org.januson.aoc2017.day01

import java.io.File


fun main(args: Array<String>) {
    val data = File("src/main/resources/day01/first.txt")
            .readLines()
            .map { it.toCharArray() }
            .flatMap { it.asList() }
            .map { it.toString() }
            .map { it.toInt() }

    val list = CircularList(
            CircularNextIndex(data.size),
            data
    )

    val captcha = Captcha(list)
    println(captcha.solution()) // 1393
}