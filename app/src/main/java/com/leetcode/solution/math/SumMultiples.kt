package com.leetcode.solution.math

class Solution2652 {
    fun sumOfMultiples(n: Int): Int {
        return (3 .. n).filter { it % 3 == 0 || it % 5 == 0 || it % 7 == 0 }.sum()
    }

    fun sumOfMultiples1(n: Int): Int {
        var res = 0
        for (i in 1 .. n) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                res += i
        }
        return res
    }
}

fun main() {
    val solution = Solution2652()
    check(solution.sumOfMultiples(7) == 21) { "wrong result" }
    check(solution.sumOfMultiples(10) == 40) { "wrong result" }
    check(solution.sumOfMultiples(9) == 30) { "wrong result" }
}
