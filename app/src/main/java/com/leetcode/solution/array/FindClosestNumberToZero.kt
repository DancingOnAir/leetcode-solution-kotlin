package com.leetcode.solution.array

import kotlin.math.abs

class Solution2239 {
    fun findClosestNumber(nums: IntArray): Int {
        var res = Int.MAX_VALUE
        for (x in nums) {
            if (abs(x) < abs(res) || (x > 0 && x == -res))
                res = x
        }
        return res
    }
}

fun main() {
    val solution = Solution2239()
    check(solution.findClosestNumber(intArrayOf(-4,-2,1,4,8)) == 1) {"testing1 wrong result"}
    check(solution.findClosestNumber(intArrayOf(2,-1,1)) == 1) {"testing2 wrong result"}
}
