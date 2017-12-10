package org.januson.aoc2017.day02

import java.io.File


fun main(args: Array<String>) {
    val result = File("src/main/resources/day02/first.txt")
            .readLines()
            .map { it.split("\t") }
            .map { it.map { it.toInt() } }
            .map { diff(it) }
            .sum()
    println(result) // 1393
}

fun diff(list: List<Int>): Int {

    for (i in 0 until list.size) {
        for (j in 0 until list.size) {
            if (i == j) {
                continue
            }
            val first = list[i]
            val second = list[j]
            if (first % second == 0) {
                return first / second
            }
            if (second % first == 0) {
                return second / first
            }
        }
    }
    return 0
}
