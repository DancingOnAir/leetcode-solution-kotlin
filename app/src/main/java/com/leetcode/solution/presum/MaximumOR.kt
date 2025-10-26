package com.leetcode.solution.presum

class Solution2680 {
    fun maximumOr(nums: IntArray, k: Int): Long {
        var suffix = IntArray(nums.size).apply {
            for (i in nums.lastIndex - 1 downTo 0) this[i] = this[i + 1] or nums[i + 1]
        }
        var prefix = 0L
        var res = Long.MIN_VALUE
        for (i in 0..nums.lastIndex) {
            val x = nums[i].toLong()
            res = maxOf(res, prefix or x.shl(k) or suffix[i].toLong())
            prefix = prefix or x
        }
        return res
    }
}

fun main() {
    val solution = Solution2680()
    check(solution.maximumOr(intArrayOf(12,9),1) == 30L) {"test1 wrong result"}
    check(solution.maximumOr(intArrayOf(8,1,2),2) == 35L) {"test2 wrong result"}
}
