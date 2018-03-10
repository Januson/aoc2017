package org.januson.aoc2017.day15


class Judge(
        private val first: Generator,
        private var second: Generator
) {

    fun consider(count: Int): Int {
        return first.sequence()
                .zip(second.sequence())
                .take(count)
                .count { it.first.sameAs(it.second) }
    }

}