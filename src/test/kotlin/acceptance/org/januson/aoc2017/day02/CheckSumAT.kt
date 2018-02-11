package acceptance.org.januson.aoc2017.day02

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class CheckSumAT : FeatureSpec() {

    private val input = "src/main/resources/day02/first.txt"

    init {
        feature("Solution") {

            scenario("first part") {
                val result = File(input)
                        .readLines()
                        .map { it.split("\t") }
                        .map { it.map { it.toInt() } }
                        .map { difference(it) }
                        .sum()
                result shouldBe 50376
            }

            scenario("second part") {
                val result = File(input)
                        .readLines()
                        .map { it.split("\t") }
                        .map { it.map { it.toInt() } }
                        .map { diff(it) }
                        .sum()
                result shouldBe 267
            }

        }
    }

    private fun difference(list: List<Int>): Int {
        val max = list.max()
        val min = list.min()
        return max!! - min!!
    }

    private fun diff(list: List<Int>): Int {

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
}

