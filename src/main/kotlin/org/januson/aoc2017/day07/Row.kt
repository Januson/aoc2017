package org.januson.aoc2017.day07

class Row(
        private val text: String
) {

    private val delimiter = " -> "
    private val nameWeightDelimiter = " "
    private val programDelimiter = ", "

    private val weightPrefix = "("
    private val weightSuffix = ")"

    fun program(): String {
        val programPart = text.substringBefore(delimiter)
        return programPart.substringBefore(nameWeightDelimiter)
    }

    fun weight(): Int {
        val programPart = text.substringBefore(delimiter)
        val weight = programPart
                .substringAfter(nameWeightDelimiter)
                .removeSurrounding(weightPrefix, weightSuffix)
        return weight.toInt()
    }

    fun dependencies(): List<String> {
        if (!text.contains(delimiter)) {
            return emptyList()
        }
        return parsedDependencies()
    }

    private fun parsedDependencies(): List<String> {
        val subPart = text.substringAfter(delimiter)
        return subPart.split(programDelimiter)
    }

}