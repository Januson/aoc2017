package acceptance.org.januson.aoc2017.day07

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day07.Root
import org.januson.aoc2017.day07.Row
import java.io.File
import kotlin.math.absoluteValue

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
                val programs = data.associateBy { it.program() }
                val unbalance = Unbalance(programs)

                unbalance.find(root) shouldBe 0
            }

        }
    }

}


class Unbalance(private val programs: Map<String, Row>) {

    val w: MutableList<List<Int>> = ArrayList()

    fun find(root: Root): Int {
        find(root.name())
        return 0
    }

    private fun find(root: String) {
        finds(root)
        w.filter { it.size > 1 }.forEach { println(it) }
    }

    private fun finds(root: String) {
        val program = row(root)
        if (program.dependencies().isEmpty()) {
            w.add(listOf(program.weight()).distinct())
        }
        val dependencies = program.dependencies()
        dependencies.forEach { finds(it) }
        w.add(dependencies.map { row(it).weight() }.distinct())
    }

    private fun row(programName: String): Row {
        return programs[programName] ?: throw NotFound()
    }

    private fun dependencies(program: Row): List<Row> {
        return program.dependencies().map { row(it) }
    }

    private fun balanced(dependencies: List<Row>): Boolean {
        return dependencies.distinctBy { it.weight() }.size == 1
    }

}

class NotFound : Exception("Row not found")

