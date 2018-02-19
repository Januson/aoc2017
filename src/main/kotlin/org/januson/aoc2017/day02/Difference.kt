package org.januson.aoc2017.day02

interface Difference {

    fun calculate(): Int

}

class MinMaxDifference(private val list: List<Int>) : Difference {

    override fun calculate(): Int {
        val max = list.max()
        val min = list.min()
        return max!! - min!!
    }

}

class EvenlyDivisibleDifference(private val list: List<Int>) : Difference {

    override fun calculate(): Int {
        for (i in 0 until list.size) {
            for (j in 0 until list.size) {
                if (i == j) {
                    continue
                }
                val first = list[i]
                val second = list[j]
                if (first % second == 0) {
                    return first / second
                }
                if (second % first == 0) {
                    return second / first
                }
            }
        }
        return 0
    }

}