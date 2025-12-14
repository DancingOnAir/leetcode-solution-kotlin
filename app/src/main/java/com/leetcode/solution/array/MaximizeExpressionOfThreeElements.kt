package com.leetcode.solution.array

import kotlin.math.min

class Solution3745 {
    fun maximizeExpressionOfThree(nums: IntArray): Int {
        var a = Int.MIN_VALUE
        var b = Int.MIN_VALUE
        var c = Int.MAX_VALUE
        for (x in nums) {
            if (x > a) {
                b = a
                a = x
            }
            else if (x > b) {
                b = x
            }
            c = min(c, x)
        }

        return a + b - c
    }
}

fun main() {
    val solution = Solution3745()
    check(solution.maximizeExpressionOfThree(intArrayOf(1,4,2,5)) == 8) {"test1"}
    check(solution.maximizeExpressionOfThree(intArrayOf(-2,0,5,-2,4)) == 11) {"test2"}
}
