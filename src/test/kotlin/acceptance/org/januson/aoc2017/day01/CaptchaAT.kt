package acceptance.org.januson.aoc2017.day01

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day01.Captcha
import org.januson.aoc2017.day01.CircularList
import org.januson.aoc2017.day01.CircularNextIndex
import org.januson.aoc2017.day01.HalfwayNextIndex
import java.io.File

class CaptchaAT : FeatureSpec() {

    init {
        feature("Solution") {

            scenario("first part") {
                val data = File("src/main/resources/day01/first.txt")
                        .readLines()
                        .map { it.toCharArray() }
                        .flatMap { it.asList() }
                        .map { it.toString() }
                        .map { it.toInt() }

                val list = CircularList(
                        CircularNextIndex(data.size),
                        data
                )

                val captcha = Captcha(list)

                captcha.solution() shouldBe 1393
            }

            scenario("second part") {
                val data = File("src/main/resources/day01/second.txt")
                        .readLines()
                        .map { it.toCharArray() }
                        .flatMap { it.asList() }
                        .map { it.toString() }
                        .map { it.toInt() }

                val list = CircularList(
                        HalfwayNextIndex(data.size),
                        data
                )
                val captcha = Captcha(list)

                captcha.solution() shouldBe 1292
            }

        }
    }
}

