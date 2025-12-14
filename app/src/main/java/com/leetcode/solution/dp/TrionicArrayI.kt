package com.leetcode.solution.array

class Solution3637 {
    fun isTrionic(nums: IntArray): Boolean {
        val n = nums.size
        if (n < 4)
            return false

        var left = 0
        while (left < n - 1) {
            if (nums[left] >= nums[left + 1])
                break
            left++
        }
        if (left == n - 2 || left == 0)
            return false

        while (left < n - 1) {
            if (nums[left] <= nums[left + 1])
                break
            left++
        }
        if (left == n - 1 || left == 1)
            return false

        while (left < n - 1) {
            if (nums[left] >= nums[left + 1])
                return false
            left++
        }
        return true
    }
}

fun main() {
    val solution = Solution3637()
    check(solution.isTrionic(intArrayOf(1,3,5,4,2,6))) {"test1"}
    check(!solution.isTrionic(intArrayOf(2,1,3))) {"test2"}
}
