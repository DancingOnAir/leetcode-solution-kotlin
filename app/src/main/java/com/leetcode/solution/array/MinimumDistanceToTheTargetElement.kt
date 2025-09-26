package com.leetcode.solution.array

class Solution1848 {
    fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
        var left = start
        var right = start
        while (left >= 0 || right < nums.size) {
            if (left >= 0 && nums[left] == target)
                return start - left
            if (right < nums.size && nums[right] == target)
                return right - start
            left--
            right++
        }
        return -1
    }
}

fun main() {
    val solution = Solution1848()
    check(solution.getMinDistance(intArrayOf(1,2,3,4,5),5,3) == 1) {"test1 wrong result"}
    check(solution.getMinDistance(intArrayOf(1),1,0) == 0) {"test2 wrong result"}
    check(solution.getMinDistance(intArrayOf(1,1,1,1,1,1,1,1,1,1),1,0) == 0) {"test3 wrong result"}
}
