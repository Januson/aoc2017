package acceptance.org.januson.aoc2017.day04

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class MazeAT : FeatureSpec() {

    private val firstInput = "src/main/resources/day05/first.txt"

    init {
        feature("Solution") {

            scenario("first part") {
                val mazeData = File(firstInput)
                        .readLines()
                        .map { it.toInt() }

                val interrupt = Interrupt(
                        Maze(
                                mazeData,
                                IncrementVisited()
                        ))
                interrupt.escape()
                val steps = interrupt.steps

                steps shouldBe 376976
            }

            scenario("second part") {
                val mazeData = File(firstInput)
                        .readLines()
                        .map { it.toInt() }

                val interrupt = Interrupt(
                        Maze(
                                mazeData,
                                DecrementIfOverThree()
                        ))
                interrupt.escape()
                val steps = interrupt.steps

                steps shouldBe 29227751
            }

        }
    }

}

class Interrupt(
        private val maze: Maze) {

    var steps = 0
        private set
    private var location = 0

    fun escape() {
        while (maze.isInside(location)) {
            val offset = maze.visit(location)
            location += offset
            steps += 1
        }
    }
}

class Maze(cells: List<Int>, private val reaction: VisitReaction) {

    private val cells: MutableList<Int> = cells.toMutableList()

    fun isInside(location: Int): Boolean {
        return location >= 0 && location < cells.size
    }

    fun visit(location: Int): Int {
        val value = cells[location]
        cells[location] = reaction.a(value)
        return value
    }

}

interface VisitReaction {

    fun a(cell: Int): Int

}

class IncrementVisited : VisitReaction {

    override fun a(cell: Int) = cell + 1

}

class DecrementIfOverThree : VisitReaction {

    override fun a(cell: Int): Int {
        if (cell >= 3) {
            return cell - 1
        }
        return cell + 1
    }

}