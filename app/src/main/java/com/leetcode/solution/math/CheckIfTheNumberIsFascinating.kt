package com.leetcode.solution.math

class Solution2729 {
    fun isFascinating(n: Int): Boolean {
        if (n > 333)
            return false
        val s = n.toString() + (n * 2).toString() + (n * 3).toString()
        return s.all { it != '0' } && s.toSet().size == s.length
    }
}

fun main() {
    val solution = Solution2729()
    check(solution.isFascinating(192)) {"wrong result"}
    check(!solution.isFascinating(100)) {"wrong result"}
}
