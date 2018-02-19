package acceptance.org.januson.aoc2017.day02

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day02.CheckSum
import org.januson.aoc2017.day02.EvenlyDivisibleDifference
import org.januson.aoc2017.day02.MinMaxDifference
import java.io.File

class CheckSumAT : FeatureSpec() {

    private val input = "src/main/resources/day02/first.txt"

    init {
        feature("Solution") {

            scenario("first part") {
                val differences = File(input)
                        .readLines()
                        .map { it.split("\t") }
                        .map { it.map { it.toInt() } }
                        .map { MinMaxDifference(it) }
                val checkSum = CheckSum(differences)
                checkSum.value() shouldBe 50376
            }

            scenario("second part") {
                val differences = File(input)
                        .readLines()
                        .map { it.split("\t") }
                        .map { it.map { it.toInt() } }
                        .map { EvenlyDivisibleDifference(it) }
                val checkSum = CheckSum(differences)
                checkSum.value() shouldBe 267
            }

        }
    }

}
