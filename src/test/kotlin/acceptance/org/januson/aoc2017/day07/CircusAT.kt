package acceptance.org.januson.aoc2017.day07

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class CircusAT : FeatureSpec() {

    private val input = "src/main/resources/day07/first.txt"

    init {
        feature("Solution") {

            scenario("first part") {
                val data = File(input)
                        .readLines()
                        .map { Row(it) }
                val root = Root(data)
                root.name() shouldBe "cqmvs"
            }

            scenario("second part") {
                val data = File(input)
                        .readLines()
                        .map { Row(it) }
                val root = Root(data)

//                root.wea() shouldBe "ahnofa"
            }

        }
    }

}

class Root(
        private val rows: List<Row>
) {

    fun name(): String {
        val programs = mutableSetOf<String>()
        val subPrograms = mutableSetOf<String>()
        for (row in rows) {
            programs.add(row.program())
            subPrograms.addAll(row.dependencies())
        }
        return programs.minus(subPrograms).first()
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