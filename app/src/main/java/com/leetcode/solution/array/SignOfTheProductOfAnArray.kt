package com.leetcode.solution.array

class Solution1822 {
    fun arraySign(nums: IntArray): Int {
        var count = 0
        for (x in nums) {
            if (x < 0)
                count++
            else if (x == 0)
                return 0
        }
        return if (count % 2 == 0) {
            1
        } else {
            -1
        }
    }
}

fun main() {
    val solution = Solution1822()
    check(solution.arraySign(intArrayOf(-1,-2,-3,-4,3,2,1)) == 1) {"test1 wrong result"}
    check(solution.arraySign(intArrayOf(1,5,0,2,-3)) == 0) {"test2 wrong result"}
    check(solution.arraySign(intArrayOf(-1,1,-1,1,-1)) == -1) {"test3 wrong result"}
}