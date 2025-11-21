package com.leetcode.solution.math

class Solution3723 {
    fun maxSumOfSquares(num: Int, sum: Int): String {
        val q = sum / 9
        val r = sum % 9
        val extra = if (r == 0) 0 else 1
        if (q + extra > num)
            return ""
        var res = "9".repeat(q)
        if (extra > 0)
            res += r.toString()
        return res + "0".repeat(num - q - extra)
    }
}

fun main() {
    val solution = Solution3723()
    check(solution.maxSumOfSquares(2, 1) == "10") {"test4"}
    check(solution.maxSumOfSquares(1, 9) == "9") {"test4"}
    check(solution.maxSumOfSquares(2, 3) == "30") {"test1"}
    check(solution.maxSumOfSquares(2, 17) == "98") {"test2"}
    check(solution.maxSumOfSquares(1, 10) == "") {"test3"}
}
