package org.januson.aoc2017.day16

import java.util.*


interface DanceMove {

    fun dance(dancers: List<Dancer>): List<Dancer>

}

class Spin(
        private val number: Int
): DanceMove {

    override fun dance(dancers: List<Dancer>): List<Dancer> {
        val last = dancers.reversed().take(number)
        val reversed = last.reversed().toMutableList()
        reversed.addAll(dancers.dropLast(number))
        return reversed.toList()
    }

}

class Exchange(
        private val firstPosition: Int,
        private val secondPosition: Int
): DanceMove {

    override fun dance(dancers: List<Dancer>): List<Dancer> {
        val dancing = dancers.toMutableList()
        Collections.swap(dancing, firstPosition, secondPosition)
        return dancing.toList()
    }

}

class Partner(
        private val first: Dancer,
        private val second: Dancer
): DanceMove {

    override fun dance(dancers: List<Dancer>): List<Dancer> {
        val firstPosition = dancers.indexOf(first)
        val secondPosition = dancers.indexOf(second)
        if (firstPosition < 0 || secondPosition < 0) {
            println(first.name)
            println(second.name)
        }
        return Exchange(firstPosition, secondPosition).dance(dancers)
    }

}
