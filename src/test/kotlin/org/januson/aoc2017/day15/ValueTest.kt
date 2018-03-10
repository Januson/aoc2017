package org.januson.aoc2017.day15

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class ValueTest : FeatureSpec() {


    init {
        feature("Comparison") {

            scenario("same values should match") {
                val value = 5L
                val first = Value(value)
                val second = Value(value)

                val result = first.sameAs(second)

                result shouldBe true
            }

            scenario("values with same judged part should match") {
                val first = Value(245556042)
                val second = Value(1431495498)

                val sameness = first.sameAs(second)
//
                sameness shouldBe true
            }

        }
    }


}

