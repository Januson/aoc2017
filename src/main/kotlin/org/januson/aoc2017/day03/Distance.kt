package org.januson.aoc2017.day03

import kotlin.math.absoluteValue

class Distance(private val location: Location) {

    val value: Int
        get() {
            return location.x.absoluteValue + location.y.absoluteValue
        }
}