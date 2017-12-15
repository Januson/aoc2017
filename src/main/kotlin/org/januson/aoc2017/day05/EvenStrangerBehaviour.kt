package org.januson.aoc2017.day05

class EvenStrangerBehaviour : Instruction.Behaviour {

    override fun behave(offset: Int): Int {
        if (offset >= 3) {
            return offset - 1
        }
        return offset + 1
    }

}