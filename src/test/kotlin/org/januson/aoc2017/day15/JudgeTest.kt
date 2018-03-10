package org.januson.aoc2017.day15

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class JudgeTest : FeatureSpec() {


    init {
        feature("Generator A") {

            scenario("should count all matches") {
                val value = 5
                val judge = Judge(
                        SameValue(value.toLong()),
                        SameValue(value.toLong())
                )

                val result = judge.consider(value)

                result shouldBe value
            }

            scenario("should count only matches") {
                val value = 5
                val judge = Judge(
                        SameValue(value.toLong()),
                        SameValue(value.toLong() + 1)
                )

                val result = judge.consider(value)

                result shouldBe 0
            }

            scenario("fist calculated value") {
                val first = Value(245556042)
                val second = Value(1431495498)

                val sameness = first.sameAs(second)
//
                sameness shouldBe true
            }

        }
    }


}

