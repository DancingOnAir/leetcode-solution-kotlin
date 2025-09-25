package com.leetcode.solution.array

class Solution2148 {
    fun countElements(nums: IntArray): Int {
        nums.sort()
        return nums.count { it != nums[0] && it != nums[nums.size - 1]}
    }

    fun countElements1(nums: IntArray): Int {
        var mx = Int.MIN_VALUE
        var mi = Int.MAX_VALUE
        val m = mutableMapOf<Int, Int>()
        for (x in nums) {
            m[x] = m.getOrDefault(x, 0) + 1
            mx = maxOf(mx, x)
            mi = minOf(mi, x)
        }

        if (mx == mi)
            return 0
        return nums.size - m[mx]!! - m[mi]!!
    }
}

fun main() {
    val solution = Solution2148()
    check(solution.countElements(intArrayOf(11,7,2,15)) == 2) {"testing1 wrong result"}
    check(solution.countElements(intArrayOf(-3,3,3,90)) == 2) {"testing2 wrong result"}
}