package com.leetcode.solution.array

import kotlin.math.max

class Solution2016 {
    fun maximumDifference(nums: IntArray): Int {
        var res = -1
        for (i in 0..nums.size - 2) {
            for (j in i + 1 .. nums.size - 1)
                if (nums[j] - nums[i] > 0)
                    res = max(res, nums[j] - nums[i])
        }
        return res
    }
}

fun main() {
    val solution = Solution2016()
    check(solution.maximumDifference(intArrayOf(7,1,5,4)) == 4) {"testing1 wrong result"}
    check(solution.maximumDifference(intArrayOf(9,4,3,2)) == -1) {"testing2 wrong result"}
    check(solution.maximumDifference(intArrayOf(1,5,2,10)) == 9) {"testing3 wrong result"}
}
