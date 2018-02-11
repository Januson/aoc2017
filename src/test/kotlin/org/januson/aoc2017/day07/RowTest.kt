package acceptance.org.januson.aoc2017.day07

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

class Row(
        private val text: String
) {

    private val delimiter = " -> "
    private val nameWeightDelimiter = " "
    private val programDelimiter = ", "

    private val weightPrefix = "("
    private val weightSuffix = ")"

    fun program(): String {
        val programPart = text.substringBefore(delimiter)
        return programPart.substringBefore(nameWeightDelimiter)
    }

    fun weight(): Int {
        val programPart = text.substringBefore(delimiter)
        val weight = programPart
                .substringAfter(nameWeightDelimiter)
                .removeSurrounding(weightPrefix, weightSuffix)
        return weight.toInt()
    }

    fun dependencies(): List<String> {
        if (!text.contains(delimiter)) {
            return emptyList()
        }
        return parsedDependencies()
    }

    private fun parsedDependencies(): List<String> {
        val subPart = text.substringAfter(delimiter)
        return subPart.split(programDelimiter)
    }

}
