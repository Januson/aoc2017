package acceptance.org.januson.aoc2017.day07

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class CircusAT : FeatureSpec() {

    private val firstInput = "src/main/resources/day07/first.txt"

    init {
        feature("Solution") {

            scenario("first part") {
                val data = File(firstInput)
                        .readLines()
                val root = Root(data)
                root.name() shouldBe "ahnofa"
            }

            scenario("first part") {
                val data = File(firstInput)
                        .readLines()
                val root = Root(data)
                root.name() shouldBe "ahnofa"
            }

        }
    }

}

class Root(
        private val data: List<String>
) {

    private val delimiter = " -> "
    private val nameWeightDelimiter = " "
    private val programDelimiter = ", "

    fun name(): String {
        val programs = mutableSetOf<String>()
        val subPrograms = mutableSetOf<String>()
        for (row in data) {
            val programPart = row.substringBefore(delimiter)
            programs.add(programPart.substringBefore(nameWeightDelimiter))
            if (row.contains(delimiter)) {
                val subPart = row.substringAfter(delimiter)
                subPrograms.addAll(subPart.split(programDelimiter))
            }
        }
        return programs.minus(subPrograms).first()
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

    fun program(): Program {
        val programPart = text.substringBefore(delimiter)
        val name = programPart.substringBefore(nameWeightDelimiter)
        val weight = programPart
                .substringAfter(nameWeightDelimiter)
                .removeSurrounding(weightPrefix, weightSuffix)
        return Program(name, weight.toInt())
    }

}

class Program(
        private val name: String,
        private val weight: Int
) {

}

class Disc(
        private val towers: List<Tower>
) {

}

class Tower(
        private val program: Program,
        private val cisc: Disc
) {

}