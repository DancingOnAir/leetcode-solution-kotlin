package com.leetcode.solution.math

import kotlin.math.abs

class Solution3649 {
    fun perfectPairs(nums: IntArray): Long {
        val sortedNums = nums.map { abs((it)) }.sorted()
        fun binSearch(left: Int, right: Int, target: Int): Int {
            if (left >= right)
                return right
            val mid = left + (right - left) / 2
            return if (sortedNums[mid] <= target) binSearch(mid + 1, right, target) else binSearch(left, mid, target)
        }

        var res = 0L
        for (i in 0..sortedNums.lastIndex) {
            val j = binSearch(i + 1, nums.size, sortedNums[i] * 2)
            res += j - i - 1
        }

        return res
    }
}

fun main() {
    val solution = Solution3649()
    check(solution.perfectPairs(intArrayOf(0,1,2,3)) == 2L) {"test1"}
    check(solution.perfectPairs(intArrayOf(-3,2,-1,4)) == 4L) {"test2"}
    check(solution.perfectPairs(intArrayOf(1,10,100,1000)) == 0L) {"test3"}
}
