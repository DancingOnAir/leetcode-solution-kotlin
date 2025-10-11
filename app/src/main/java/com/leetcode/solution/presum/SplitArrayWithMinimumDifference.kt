package com.leetcode.solution.presum

import kotlin.math.abs

class Solution3698 {
    fun splitArray(nums: IntArray): Long {
        val n = nums.size
        val mx = nums.max()
        val mxId = nums.indexOf(mx)
        var j = mxId
        var mxCnt = 0
        while (j < n && nums[j] == nums[mxId]) {
            j++
            mxCnt++
        }

        if (mxCnt > 2) {
            return -1
        }

        var leftSum = 0L
        for (i in 0 until mxId) {
            if (nums[i] >= nums[i + 1])
                return -1
            leftSum += nums[i]
        }

        var rightSum = 0L
        for (i in j until n) {
            if (nums[i] >= nums[i - 1])
                return -1
            rightSum += nums[i]
        }

        if (mxCnt < 2) {
            if (leftSum < rightSum) {
                leftSum += mx
            } else {
                rightSum += mx
            }
        }

        return abs(leftSum - rightSum)
    }
}

fun main() {
    val solution = Solution3698()
    check(solution.splitArray(intArrayOf(2,2)) == 0L) {"test1 wrong result"}
    check(solution.splitArray(intArrayOf(1,3,2)) == 2L) {"test1 wrong result"}
    check(solution.splitArray(intArrayOf(1,2,4,3)) == 4L) {"test2 wrong result"}
    check(solution.splitArray(intArrayOf(3,1,2)) == -1L) {"test3 wrong result"}
}
