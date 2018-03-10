package org.januson.aoc2017.day16

class Dancers {

    private var dancers = generateSequence('a') { previous -> previous + 1 }
            .take(16)
            .map { Dancer(it.toString()) }
            .toList()

    fun show(): String {
        return dancers.joinToString(separator = "") { it.name }
    }

    fun dance(danceMove: DanceMove) {
        dancers = danceMove.dance(dancers)
    }

}

data class Dancer(val name: String)