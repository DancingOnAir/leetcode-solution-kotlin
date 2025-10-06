package com.leetcode.solution.array

class Solution3678 {
    fun smallestAbsent(nums: IntArray): Int {
        val avg = nums.sum() / nums.size
        var res = if (avg < 0) 1 else avg + 1
        val m = nums.toSet()
        while (res in m) {
            res++
        }
        return res
    }
}

fun main() {
    val solution = Solution3678()
    check(solution.smallestAbsent(intArrayOf(3,5)) == 6) { "test1 wrong result" }
    check(solution.smallestAbsent(intArrayOf(-1,1,2)) == 3) { "test2 wrong result" }
    check(solution.smallestAbsent(intArrayOf(4, -1)) == 2) { "test3 wrong result" }
}
