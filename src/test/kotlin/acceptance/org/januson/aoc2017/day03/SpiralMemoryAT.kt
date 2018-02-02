package acceptance.org.januson.aoc2017.day03

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day03.Distance
import org.januson.aoc2017.day03.SpiralMemory

class SpiralMemoryAT : FeatureSpec() {

    init {
        feature("Solution") {

            scenario("first part") {
                val sequence = org.januson.aoc2017.day03.Sequence()
                val value = 277678
                val result = SpiralMemory(sequence).locationOf(value)
                val distance = Distance(result)

                distance.value shouldBe 475
            }

            scenario("second part") {
                val sequence = org.januson.aoc2017.day03.Sequence()
                val value = 277678
                val result = SpiralMemory(sequence).locationOf(value)
                val distance = Distance(result)

                distance.value shouldBe 999
            }

        }
    }

}

