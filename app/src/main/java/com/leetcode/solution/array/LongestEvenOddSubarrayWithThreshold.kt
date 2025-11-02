package com.leetcode.solution.array

import kotlin.math.max

class Solution2760 {
    fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
        var res = 0
        var i = 0
        val n = nums.size
        while (i < n) {
            while (i < n && (nums[i] > threshold || nums[i] % 2 == 1)) {
                i++
            }

            var j = i + 1
            while (j < n && nums[j] <= threshold && nums[j] % 2 != nums[j - 1] % 2) {
                j++
            }

            if (i < n && j <= n)
                res = max(res, j - i)
            i = j
        }

        return res
    }

    fun longestAlternatingSubarray1(nums: IntArray, threshold: Int): Int {
        var res = 0
        var cur = 0
        for ((i, x) in nums.withIndex()) {
            if (x <= threshold && ((cur == 0 && x % 2 == 0) || (cur > 0 && x % 2 != nums[i - 1] % 2))) {
                cur++
                res = max(res, cur)
            } else {
                cur = if (x <= threshold && x % 2 == 0) 1 else 0
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution2760()
    check(solution.longestAlternatingSubarray(intArrayOf(3,2,5,4),5) == 3) {"test1 wrong result"}
    check(solution.longestAlternatingSubarray(intArrayOf(1,2),2) == 1) {"test2 wrong result"}
    check(solution.longestAlternatingSubarray(intArrayOf(2,3,4,5),4) == 3) {"test3 wrong result"}
}
