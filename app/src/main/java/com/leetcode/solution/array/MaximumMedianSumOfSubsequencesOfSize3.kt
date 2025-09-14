package com.leetcode.solution.array

class Solution3627 {
    fun maximumMedianSum(nums: IntArray): Long {
        nums.sortDescending()
        var res = 0L
        for (i in 0 until nums.size / 3 ) {
            res += nums[2 * i + 1]
        }
        return res
    }
}

fun main() {
    val solution = Solution3627()
    check(solution.maximumMedianSum(intArrayOf(2,1,3,2,1,3)) == 5L) {"testing1 wrong result"}
    check(solution.maximumMedianSum(intArrayOf(1,1,10,10,10,10)) == 20L) {"testing2 wrong result"}
}