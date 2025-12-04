package com.leetcode.solution.math

import kotlin.math.sqrt

class Solution0492 {
    fun constructRectangle(area: Int): IntArray {
        val n = sqrt(area.toDouble()).toInt()
        var highestFactor = -1
        for (x in n downTo 1) {
            if (area % x == 0) {
                highestFactor = x
                break
            }
        }
        return intArrayOf(area / highestFactor, highestFactor)
    }
}

fun main() {
    val solution = Solution0492()
    check(solution.constructRectangle(4).contentEquals(intArrayOf(2, 2))) {"test1"}
    check(solution.constructRectangle(37).contentEquals(intArrayOf(37, 1))) {"test2"}
    check(solution.constructRectangle(122122).contentEquals(intArrayOf(427,286))) {"test3"}
}
