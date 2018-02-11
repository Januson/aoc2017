package org.januson.aoc2017.day06

import java.io.File

fun main(args: Array<String>) {
    val bankList = File("src/main/resources/day06/first.txt")
            .readLines()
            .flatMap { it.split("\t") }
            .map { it.toInt() }
            .map { Bank(it) }

    val banks = Banks(bankList)
    val debugger = Debugger(banks)
//    val most = debugger.largestBankIndex()
//    println(most)
}

class Debugger(
        private val banks: Banks) {
        private val visited: Set<Bank> = mutableSetOf()

    fun debug() {
    }

//    fun redistribute() {
//        val index = banks.indexOfLargest()
//        // todo redistribute move to banks
//        val funds = banks.drainBankAt(index)
//    }

}

class Banks(private val banks: List<Bank>) {
    fun redistributeLargest() {
        val indexOfLargest = indexOfLargest()
        val blocksToRedistribute = banks[indexOfLargest].blocks()
        
        banks.iterator()
    }

    private fun indexOfLargest(): Int {
        return banks
                .withIndex()
                .maxBy { it.value.blocks() }
                ?.index!!
    }
}
class Bank(
        private var blocks: Int) {

    fun blocks(): Int {
        return blocks
    }

    fun allocate() {
        blocks++
    }

    fun clear() {
        blocks = 0
    }
}