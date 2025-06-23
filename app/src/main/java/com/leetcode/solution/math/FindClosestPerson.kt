package com.leetcode.solution.math

import kotlin.math.absoluteValue

class SolutionQ3516 {
    fun findClosest(x: Int, y: Int, z: Int): Int {
        val diff = (z - x).absoluteValue - (z - y).absoluteValue
        return when {
            diff == 0 -> 0
            diff < 0 -> 1
            else -> 2
        }
    }
}

fun main() {
    val solution = SolutionQ3516()
    check(solution.findClosest(2,7,4) == 1) { "wrong result" }
    check(solution.findClosest(2,5,6) == 2) { "wrong result" }
    check(solution.findClosest(1,5,3) == 0) { "wrong result" }
}