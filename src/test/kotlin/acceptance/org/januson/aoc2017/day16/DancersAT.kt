package acceptance.org.januson.aoc2017.day16

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import org.januson.aoc2017.day16.*
import java.io.File

class DancersAT : FeatureSpec() {

    private val firstInput = "src/main/resources/day16/first.txt"

    init {
        feature("Solution") {

            scenario("first part") {
                val moves = moves(firstInput)
                val dancers = Dancers()

                dancers.dance(moves)

                dancers.show() shouldBe "giadhmkpcnbfjelo"
            }

            scenario("second part") {
                val moves = moves(firstInput)
                val dancers = Dancers()

                repeat(ONE_BILLION) {
                    dancers.dance(moves)
                }

                dancers.show() shouldBe "njfgilbkcoemhpad"
            }

        }
    }

    class Positions(val start: String, private val end: String) {

        fun list(): List<Int> {
            return start.map { end.indexOf(it) }
        }

    }

    class Dance(private val positions: Positions) {

        fun times(n: Int): String {
            val moves = positions.list()
            var dancers = positions.start.toCharArray().toList()
            repeat(n) {
                dancers = move(dancers, moves)
            }
            return dancers.joinToString("")
        }

        fun move(dancers: List<Char>, moves: List<Int>): List<Char> {
            return moves.map { dancers[it] }
        }

    }

    private fun moves(path: String): List<DanceMove> {
        return File(path)
                .readLines()
                .map { it.split(",") }
                .flatMap { it.toList() }
                .map { move(it) }
    }

    private fun move(move: String): DanceMove {
        return when (move.first()) {
            's' -> toSpin(move)
            'x' -> toExchange(move)
            'p' -> toPartner(move)
            else -> throw IllegalDanceMove("$move is not a valid move")
        }
    }

    private fun toSpin(move: String): DanceMove {
        return Spin(move.substring(1).toInt())
    }

    private fun toExchange(move: String): DanceMove {
        val parts = move.substring(1).split("/")
        return Exchange(parts.first().toInt(), parts.last().toInt())
    }

    private fun toPartner(move: String): DanceMove {
        val parts = move.substring(1).split("/")
        return Partner(parts.first().first(), parts.last().first())
    }

    private companion object {
        private const val ONE_BILLION = 1_000_000_000
    }

}

class IllegalDanceMove(message: String) : Exception(message)
