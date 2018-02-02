package acceptance.org.januson.aoc2017.day04

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class PassPhrasesAT : FeatureSpec() {

    private val input = "src/main/resources/day04/first.txt"

    init {
        feature("Solution") {

            scenario("first part") {
                val result = File(input)
                        .readLines()
                        .map { it.split(" ") }
                        .filter { it.size == it.toSet().size }
                        .size

                result shouldBe 383
            }

            scenario("second part") {
                val result = File(input)
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

                result shouldBe 265
            }

        }
    }

}

