package org.januson.aoc2017.day10

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day15.DefaultGenerator
import org.januson.aoc2017.day15.Value

class GeneratorTest : FeatureSpec() {

    private val startA = 883L
    private val factorA = 16807L
    private val startB = 879
    private val factorB = 48271

    init {
        feature("Generator A") {

            val firstValue = 14840581

//            scenario("starts at") {
//                val generator = DefaultGenerator(factorA, Value(startA))
//
//                val current = generator.current()
//
//                current.value shouldBe startA
//            }
//
//            scenario("fist calculated value") {
//                val generator = DefaultGenerator(factorA, Value(startA))
//
//                generator.advance()
//                val current = generator.current()
//
//                current.value shouldBe firstValue
//            }
        }
    }
}
