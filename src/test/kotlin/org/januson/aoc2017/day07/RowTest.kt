package org.januson.aoc2017.day07

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class RowTest : FeatureSpec() {

    init {
        feature("parsing simple row") {

            val rowValue = "nwlkk (84)"
            val expectedProgram = "nwlkk"
            val expectedWeight = 84

            scenario("can parse program") {
                val row = Row(rowValue)

                row.program() shouldBe expectedProgram
            }

            scenario("can parse weight") {
                val row = Row(rowValue)

                row.weight() shouldBe expectedWeight
            }

            scenario("can parse dependencies") {
                val row = Row(rowValue)

                row.dependencies() shouldBe emptyList<String>()
            }
        }

        feature("parsing row with dependencies") {

            val rowValue = "redeub (57) -> hxhguzh, vkmxs"
            val expectedProgram = "redeub"
            val expectedWeight = 57
            val expectedDependencies = listOf("hxhguzh", "vkmxs")

            scenario("can parse program") {
                val row = Row(rowValue)

                row.program() shouldBe expectedProgram
            }

            scenario("can parse weight") {
                val row = Row(rowValue)

                row.weight() shouldBe expectedWeight
            }

            scenario("can parse dependencies") {
                val row = Row(rowValue)

                row.dependencies() shouldBe expectedDependencies
            }
        }
    }

}
