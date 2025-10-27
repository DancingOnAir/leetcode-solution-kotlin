package com.leetcode.solution.bitManipulation

import kotlin.math.pow

class Solution3513 {
    fun uniqueXorTriplets(nums: IntArray): Int {
        val n = nums.size
        if (n < 3)
            return n
        var res = n.toString(2).length
        return 2.0.pow(res).toInt()
    }
}

fun main() {
    val solution = Solution3513()
    check(solution.uniqueXorTriplets(intArrayOf(3,1,2,4)) == 8) {"test1 wrong result"}
    check(solution.uniqueXorTriplets(intArrayOf(1,2)) == 2) {"test1 wrong result"}
    check(solution.uniqueXorTriplets(intArrayOf(3,1,2)) == 4) {"test2 wrong result"}
}
