package com.leetcode.solution.monotonic

class Solution3676 {
    fun bowlSubarrays(nums: IntArray): Long {
        val stk = mutableListOf<Int>()
        var res = 0L
        for ((r, x) in nums.withIndex()) {
            while (stk.isNotEmpty() && nums[stk.last()] <= x) {
                val l = stk.removeAt(stk.lastIndex)
                if ((r - l + 1) >= 3)
                    res++
            }
            if (stk.isNotEmpty() && (r - stk.last() + 1) >= 3) {
                res++
            }
            stk.add(r)
        }
        return res
    }
}

fun main() {
    val solution = Solution3676()
    check(solution.bowlSubarrays(intArrayOf(2,5,3,1,4)) == 2L) { "test1 wrong result" }
    check(solution.bowlSubarrays(intArrayOf(5,1,2,3,4)) == 3L) { "test2 wrong result" }
    check(solution.bowlSubarrays(intArrayOf(1000000000,999999999,999999998)) == 0L) { "test3 wrong result" }
}
