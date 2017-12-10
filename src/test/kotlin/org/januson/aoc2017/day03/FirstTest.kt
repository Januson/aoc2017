package org.januson.aoc2017.day03

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day01.Captcha
import org.januson.aoc2017.day01.CircularList
import org.januson.aoc2017.day01.CircularNextIndex

class FirstTest : FeatureSpec() {

    init {
        feature("Solution") {

            scenario("When list is empty, solution should be zero") {
                val list = listOf<Int>()
                val data = CircularList(
                        CircularNextIndex(list.size),
                        list
                )
                val solution = Captcha(data).solution()

                solution shouldBe 0
            }

            scenario("When no digit matches, solution should be zero") {
                val list = listOf<Int>()
                val data = CircularList(
                        CircularNextIndex(list.size),
                        list
                )
                val solution = Captcha(data).solution()

                solution shouldBe 0
            }

            scenario("When digit matches next digit is is summed") {
                val list = listOf(1, 1, 2)
                val data = CircularList(
                        CircularNextIndex(list.size),
                        list
                )
                val solution = Captcha(data).solution()

                solution shouldBe 1
            }

            scenario("When first and last digit matches the last is one of summed digits") {
                val list = listOf(1, 1, 1)
                val data = CircularList(
                        CircularNextIndex(list.size),
                        list
                )
                val solution = Captcha(data).solution()

                solution shouldBe 3
            }

        }
    }
}