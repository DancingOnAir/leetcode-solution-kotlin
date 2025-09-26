package com.leetcode.solution.array

import kotlin.math.max

class Solution1800 {
    fun maxAscendingSum(nums: IntArray): Int {
        val stk = mutableListOf<Int>()
        var res = Int.MIN_VALUE
        for (x in nums) {
            if (stk.isNotEmpty() && x <= stk.last()) {
                res = max(res, stk.sum())
                stk.clear()
            }
            stk.add(x)
        }
        return max(res, stk.sum())
    }
}

fun main() {
    val solution = Solution1800()
    check(solution.maxAscendingSum(intArrayOf(10,20,30,40)) == 100) {"testing1 wrong result"}
    check(solution.maxAscendingSum(intArrayOf(10,20,30,5,10,50)) == 65) {"testing1 wrong result"}
    check(solution.maxAscendingSum(intArrayOf(10,20,30,40,50)) == 150) {"testing2 wrong result"}
    check(solution.maxAscendingSum(intArrayOf(12,17,15,13,10,11,12)) == 33) {"testing3 wrong result"}
}
