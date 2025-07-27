package com.leetcode.solution.math

class Solution1518 {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        return numBottles + (numBottles - 1) / (numExchange - 1)
    }

    fun numWaterBottles1(numBottles: Int, numExchange: Int): Int {
        var x = numBottles
        var res = numBottles
        while (x >= numExchange) {
            res += x / numExchange
            x -= (x / numExchange) * (numExchange - 1)
        }

        return res
    }
}

fun main() {
    val solution = Solution1518()
    check(solution.numWaterBottles(9,3) == 13) { "wrong result" }
    check(solution.numWaterBottles(15,4) == 19) { "wrong result" }
}
