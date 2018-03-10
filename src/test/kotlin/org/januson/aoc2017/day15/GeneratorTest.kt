package org.januson.aoc2017.day10

import io.kotlintest.specs.FeatureSpec

class GeneratorTest : FeatureSpec() {

    private val startA = 883L
    private val factorA = 16807L
    private val startB = 879
    private val factorB = 48271

    init {
        feature("Generator A") {

            val firstValue = 14840581

//            scenario("starts at") {
//                val generator = SequenceGenerator(factorA, Value(startA))
//
//                val current = generator.current()
//
//                current.value shouldBe startA
//            }
//
//            scenario("fist calculated value") {
//                val generator = SequenceGenerator(factorA, Value(startA))
//
//                generator.advance()
//                val current = generator.current()
//
//                current.value shouldBe firstValue
//            }
        }
    }
}
