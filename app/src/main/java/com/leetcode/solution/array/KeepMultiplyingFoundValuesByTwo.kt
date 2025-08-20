package com.leetcode.solution.array

class Solution2154 {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        var res = original
        nums.sort()
        for (i in nums) {
            if (res == i) {
                res *= 2
            }
        }
        return res
    }

    fun findFinalValue1(nums: IntArray, original: Int): Int {
        var res = original
        val m = nums.toSet()
        while (res in m) {
            res *= 2
        }
        return res
    }
}

fun main() {
    val solution = Solution2154()
    check(solution.findFinalValue(intArrayOf(5,3,6,1,12),3) == 24) {"testing1 wrong result"}
    check(solution.findFinalValue(intArrayOf(2,7,9),4) == 4) {"testing2 wrong result"}
}
