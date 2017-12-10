package org.januson.aoc2017.day01

class Captcha(private val data: CircularList) {

    fun solution(): Int {
        return data
                .withIndex()
                .filter { it.value == data.next(it.index) }
                .sumBy { it.value }
    }

}
