package org.januson.aoc2017.day07

class Root(
        private val rows: List<Row>
) {

    fun name(): String {
        val programs = mutableSetOf<String>()
        val subPrograms = mutableSetOf<String>()
        for (row in rows) {
            programs.add(row.program())
            subPrograms.addAll(row.dependencies())
        }
        return programs.minus(subPrograms).first()
    }

}