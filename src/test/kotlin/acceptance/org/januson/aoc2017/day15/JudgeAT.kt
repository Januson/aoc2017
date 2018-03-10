package acceptance.org.januson.aoc2017.day15

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day15.DefaultGenerator
import org.januson.aoc2017.day15.Judge
import org.januson.aoc2017.day15.Value

class JudgeAT : FeatureSpec() {

    private val factorA = 16807L
    private val factorB = 48271L
    private val startA = 883L
    private val startB = 879L
    private val fortyMillion = 40_000_000
    private val fiveMillion = 5_000_000


    init {
        feature("Solution") {

            scenario("first part") {
                val judge = Judge(
                        DefaultGenerator(factorA, Value(startA), 1),
                        DefaultGenerator(factorB, Value(startB), 1)
                )

                val matches = judge.consider(fortyMillion)

                matches shouldBe 609
            }

            scenario("second part") {
                val judge = Judge(
                        DefaultGenerator(factorA, Value(startA), 4),
                        DefaultGenerator(factorB, Value(startB), 8)
                )

                val matches = judge.consider(fiveMillion)

                matches shouldBe 253
            }

        }
    }

}
