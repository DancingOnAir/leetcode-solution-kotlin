package com.leetcode.solution.array

import kotlin.math.max

class Solution3638 {
    fun maxBalancedShipments(weight: IntArray): Int {
        var res = 0
        var mx = Int.MIN_VALUE
        for (x in weight) {
            if (x < mx) {
                res++
                mx = Int.MIN_VALUE
            } else {
                mx = max(mx, x)
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution3638()
    check(solution.maxBalancedShipments(intArrayOf(2,5,1,4,3)) == 2) { "test1 wrong result" }
    check(solution.maxBalancedShipments(intArrayOf(4,4)) == 0) { "test1 wrong result" }
}
