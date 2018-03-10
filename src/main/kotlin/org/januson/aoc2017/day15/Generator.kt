package org.januson.aoc2017.day15

interface Generator {

    fun sequence(): Sequence<Value>

}

class SequenceGenerator(
        private val factor: Long,
        private val start: Value
) : Generator {

    override fun sequence(): Sequence<Value> {
        return generateSequence(start.next(factor)) { previous ->
            (previous.next(factor))
        }
    }

}

class Criteriator(
        private val generator: Generator,
        private val multiple: Int
) : Generator {

    override fun sequence(): Sequence<Value> {
        return generator
                .sequence()
                .filter { it.divisibleBy(multiple) }
    }

}

class SameValue(private val value: Long) : Generator {

    override fun sequence(): Sequence<Value> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
