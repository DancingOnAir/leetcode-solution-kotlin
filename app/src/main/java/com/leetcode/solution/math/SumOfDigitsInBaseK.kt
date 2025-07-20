package com.leetcode.solution.math

class Solution1837 {
    fun sumBase(n: Int, k: Int): Int {
        return generateSequence(n) { if (it > 0) it / k else null }.sumBy { it % k }
    }

    fun sumBase1(n: Int, k: Int): Int {
        var x = n
        var res = 0
        while (x > 0) {
            res += x % k
            x /= k
        }

        return res
    }
}

fun main() {
    val solution = Solution1837()
    check(solution.sumBase(34,6) == 9) { "wrong result" }
    check(solution.sumBase(10,10) == 1) { "wrong result" }
}
