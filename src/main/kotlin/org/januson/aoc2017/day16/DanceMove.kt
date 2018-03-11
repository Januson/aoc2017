package org.januson.aoc2017.day16


interface DanceMove {

    fun dance(dancers: String): String

}

class Spin(
        private val times: Int
) : DanceMove {

    override fun dance(dancers: String): String {
        return dancers.substring(dancers.length - times) + dancers.substring(0, dancers.length - times)
    }

}

class Exchange(
        private val firstPosition: Int,
        private val secondPosition: Int
) : DanceMove {

    override fun dance(dancers: String): String {
        val chars = dancers.toCharArray()
        chars[secondPosition] = dancers[firstPosition]
        chars[firstPosition] = dancers[secondPosition]
        return String(chars)
    }

}

class Partner(
        private val first: Char,
        private val second: Char
) : DanceMove {

    override fun dance(dancers: String): String {
        return Exchange(dancers.indexOf(first), dancers.indexOf(second)).dance(dancers)
    }

}
