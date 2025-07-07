package com.leetcode.solution.math

class Solution2651 {
    fun findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int) = (arrivalTime + delayedTime) % 24

    fun findDelayedArrivalTime1(arrivalTime: Int, delayedTime: Int): Int {
        return (arrivalTime + delayedTime) % 24
    }
}

fun main() {
    val solution = Solution2651()
    check(solution.findDelayedArrivalTime(15, 5) == 20) { "wrong result" }
    check(solution.findDelayedArrivalTime(13, 11) == 0) { "wrong result" }
}
