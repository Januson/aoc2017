package org.januson.aoc2017.day16

import java.io.File

class Dancers {

    private val knownDances = mutableMapOf<String, String>()

    private var dancers = generateSequence('a') { previous -> previous + 1 }
            .take(16)
            .joinToString(separator = "")

    fun show(): String {
        return dancers
    }

    private fun known(dance: String): Boolean {
        return knownDances.containsKey(dance)
    }

    private fun danceAhead() {
        dancers = knownDances[dancers]?: throw IllegalStateException("Unknown Dance")
    }

    private fun memorize(dance: String) {
        knownDances[dance] = dancers
    }

    fun dance(moves: List<DanceMove>) {
        if (known(dancers)) {
            danceAhead()
            return
        }
        val current = dancers
        moves.forEach { move -> dance(move) }
        memorize(current)
    }

    private fun dance(danceMove: DanceMove) {
        dancers = danceMove.dance(dancers)
    }

}
