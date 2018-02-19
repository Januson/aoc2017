package org.januson.aoc2017.day02

class CheckSum(private val differences: List<Difference>) {
    fun value(): Int {
        return differences
                .map { it.calculate() }
                .sum()
    }
}