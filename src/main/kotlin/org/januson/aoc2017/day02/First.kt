package org.januson.aoc2017.day02

import java.io.File


fun main(args: Array<String>) {
    val result = File("src/main/resources/day02/first.txt")
            .readLines()
            .map { it.split("\t") }
            .map { it.map { it.toInt() } }
            .map { difference(it) }
//            .map { it.sum() }
//            .filter { it. }
//            .map { it.toCharArray() }
//            .flatMap { it.asList() }
//            .map { it.toString() }
//            .map { it.toInt() }
            .sum()
    println(result) // 1393
}

fun difference(list: List<Int>): Int {
    val max = list.max()
    val min = list.min()
    return max!! - min!!
}