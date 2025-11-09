package com.leetcode.solution.hashmap

class Solution3718 {
    fun missingMultiple(nums: IntArray, k: Int): Int {
        var res = k
        val m = nums.toSet()
        while (res in m) {
            res += k
        }
        return res
    }
}

fun main() {
    val solution = Solution3718()
    check(solution.missingMultiple(intArrayOf(8,2,3,4,6), 2) == 10) {"test1 wrong result"}
    check(solution.missingMultiple(intArrayOf(1,4,7,10,15), 5) == 5) {"test2 wrong result"}
}