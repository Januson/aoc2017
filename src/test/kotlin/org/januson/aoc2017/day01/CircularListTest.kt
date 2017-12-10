package org.januson.aoc2017.day01

import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.specs.FeatureSpec

class CircularListTest : FeatureSpec() {

    init {
        feature("Solution") {

            scenario("When list is empty, solution should be zero") {
                val data = listOf(1, 2)
                val list = CircularList(
                        CircularNextIndex(data.size),
                        data
                )
                val next = list.next(0)

                next shouldBe 2
            }

            scenario("When no digit matches, solution should be zero") {
                val data = listOf(1, 2)
                val list = CircularList(
                        CircularNextIndex(data.size),
                        data
                )
                val next = list.next(1)

                next shouldBe 1
            }

            scenario("Argument that is not passed to the program should not be present in matches") {
                val data = listOf<Int>()

                shouldThrow<IllegalStateException> {
                    CircularList(
                            CircularNextIndex(data.size),
                            data
                    ).next(1)
                }
            }

        }
    }
}



