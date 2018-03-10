package org.januson.aoc2017.day15

interface Generator {

    fun sequence(): Sequence<Value>

}

class DefaultGenerator(
        private val factor: Long,
        private val start: Value,
        private val criteria: Int
) : Generator {

    override fun sequence(): Sequence<Value> {
        return generateSequence(start.next(factor)) { previous ->
            (previous.next(factor))
        }.filter { it.divisibleBy(criteria) }
    }

}

class SameValue(private val value: Long) : Generator {

    override fun sequence(): Sequence<Value> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
