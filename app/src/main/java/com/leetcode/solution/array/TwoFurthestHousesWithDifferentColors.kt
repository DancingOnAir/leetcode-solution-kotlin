package com.leetcode.solution.array

import kotlin.math.max

class Solution2078 {
    fun maxDistance(colors: IntArray): Int {
        var res= 0
        for (i in 0 until colors.size) {
            if (colors[i] != colors.first())
                res = max(res, i)
            if (colors[i] != colors.last())
                res = max(res, colors.size - i - 1)
        }
        return res
    }
}

fun main() {
    val solution = Solution2078()
    check(solution.maxDistance(intArrayOf(6,6,6,6,6,6,6,6,6,19,19,6,6)) == 10) {"testing1 wrong result"}
    check(solution.maxDistance(intArrayOf(1,1,1,6,1,1,1)) == 3) {"testing1 wrong result"}
    check(solution.maxDistance(intArrayOf(1,8,3,8,3)) == 4) {"testing2 wrong result"}
    check(solution.maxDistance(intArrayOf(0,1)) == 1) {"testing3 wrong result"}
}
