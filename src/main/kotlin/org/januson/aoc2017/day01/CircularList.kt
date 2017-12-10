package org.januson.aoc2017.day01

class CircularList(

        private val nextIndex: NextIndexStrategy,
        private val list: List<Int>

) : Iterable<Int> {

    override fun iterator(): Iterator<Int> {
        return list.iterator()
    }

    fun next(index: Int): Int {
        if (list.isEmpty()) {
            throw IllegalStateException("List is empty.")
        }
        return list[nextIndex.get(index)]
    }

}
