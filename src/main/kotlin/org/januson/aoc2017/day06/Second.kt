package org.januson.aoc2017.day06

import java.io.File

fun main(args: Array<String>) {
    val result = File("src/main/resources/day04/first.txt")
            .readLines()
            .map { it.split(" ") }
            .filter { it.size == it.toSet().size }
            .map {
                it
                        .map { it.toCharArray() }
                        .map { it.sorted() }
                        .map { it.joinToString(separator = "") }
            }
            .filter { it.size == it.toSet().size }
            .size

    println(result)
}

