package com.leetcode.solution.presum

import kotlin.math.max

class Solution0525 {
    fun findMaxLength(nums: IntArray): Int {
        val pos = mutableMapOf<Int, Int>()
        pos.put(0, -1)
        var res = 0
        var tot = 0
        for ((i, x) in nums.withIndex()) {
            tot += if (x == 1) 1 else -1
            if (tot in pos) {
                res = max(res, i - pos[tot]!!)
            } else {
                pos[tot] = i
            }
        }

        return res
    }
}

fun main() {
    val solution = Solution0525()
    check(solution.findMaxLength(intArrayOf(0,1)) == 2) {"test1 wrong result"}
    check(solution.findMaxLength(intArrayOf(0,1,0)) == 2) { "test2 wrong result" }
    check(solution.findMaxLength(intArrayOf(0,1,0)) == 2) { "test3 wrong result" }
}