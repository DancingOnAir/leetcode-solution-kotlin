package com.leetcode.solution.array

class Solution1991 {
    fun findMiddleIndex(nums: IntArray): Int {
        val tot = nums.sum()
        var res = -1
        var acc = 0
        for ((i, x) in nums.withIndex()) {
            if (acc * 2 + x == tot) {
                return i
            }
            acc += x
        }

        return res
    }
}

fun main() {
    val solution = Solution1991()
    check(solution.findMiddleIndex(intArrayOf(2,3,-1,8,4)) == 3) {"test1 wrong result"}
    check(solution.findMiddleIndex(intArrayOf(1,-1,4)) == 2) {"test2 wrong result"}
    check(solution.findMiddleIndex(intArrayOf(2,5)) == -1) {"test3 wrong result"}
}