package com.leetcode.solution.math

class Solution2600 {
    fun kItemsWithMaximumSum(numOnes: Int, numZeros: Int, numNegOnes: Int, k: Int): Int {
        return when {
            k <= numOnes -> k
            k <= numOnes + numZeros -> numOnes
            else -> numOnes - (k - numOnes - numZeros)
        }
    }
}

fun main() {
    val solution = Solution2600()
    check(solution.kItemsWithMaximumSum(3,2,0,2) == 2) { "wrong result" }
    check(solution.kItemsWithMaximumSum(3,2,0,4) == 3) { "wrong result" }
}
