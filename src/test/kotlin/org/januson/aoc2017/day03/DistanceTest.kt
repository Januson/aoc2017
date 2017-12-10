package org.januson.aoc2017.day03

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day01.Captcha
import org.januson.aoc2017.day01.CircularList
import org.januson.aoc2017.day01.CircularNextIndex

class DistanceTest : FeatureSpec() {

    init {
        feature("Manhattan distance from ") {

            scenario("asd") {
                val location = Location(20, 20)
                val distance = Distance(location)

                distance.value shouldBe 40
            }

        }
    }
}