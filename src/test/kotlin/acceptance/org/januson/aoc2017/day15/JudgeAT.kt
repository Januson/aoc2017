package acceptance.org.januson.aoc2017.day15

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day15.Criteriator
import org.januson.aoc2017.day15.Judge
import org.januson.aoc2017.day15.SequenceGenerator
import org.januson.aoc2017.day15.Value

class JudgeAT : FeatureSpec() {

    init {
        feature("Solution") {

            scenario("first part") {
                val judge = Judge(
                    SequenceGenerator(FACTOR_A, Value(START_A)),
                    SequenceGenerator(FACTOR_B, Value(START_B))
                )

                val matches = judge.consider(FORTY_MILLION)

                matches shouldBe 609
            }

            scenario("second part") {
                val judge = Judge(
                    Criteriator(
                        SequenceGenerator(
                            FACTOR_A,
                            Value(START_A)
                        ),
                        MULTIPLES_OF_FOUR
                    ),
                    Criteriator(
                        SequenceGenerator(
                            FACTOR_B,
                            Value(START_B)
                        ),
                        MULTIPLES_OF_EIGHT)
                )

                val matches = judge.consider(FIVE_MILLION)

                matches shouldBe 253
            }

        }
    }

    private companion object {
        private const val MULTIPLES_OF_FOUR = 4
        private const val MULTIPLES_OF_EIGHT = 8
        private const val FACTOR_A = 16807L
        private const val FACTOR_B = 48271L
        private const val START_A = 883L
        private const val START_B = 879L
        private const val FORTY_MILLION = 40_000_000
        private const val FIVE_MILLION = 5_000_000

    }
}
