package org.januson.aoc2017.day16

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class DancersTest : FeatureSpec() {

    init {
        feature("dancers") {

            scenario("should start at alphabetical order") {
                val dancers = Dancers()

                dancers.show() shouldBe "abcdefghijklmnop"
            }

        }

        feature("spin") {
            scenario("one dancer moves after single spin") {
                val dancers = Dancers()

                dancers.dance(Spin(1))

                dancers.show() shouldBe "pabcdefghijklmno"
            }

            scenario("three dancers moves after three spins") {
                val dancers = Dancers()

                dancers.dance(Spin(3))

                dancers.show() shouldBe "nopabcdefghijklm"
            }
        }

        feature("exchange") {
            scenario("one dancer moves after single spin") {
                val dancers = Dancers()

                dancers.dance(Exchange(0, 1))

                dancers.show() shouldBe "bacdefghijklmnop"
            }

            scenario("three dancers moves after three spins") {
                val dancers = Dancers()

                dancers.dance(Exchange(1, 15))

                dancers.show() shouldBe "apcdefghijklmnob"
            }
        }

    }

}
