package com.leetcode.solution.math

class Solution1137 {
    fun tribonacci(n: Int): Int {
        return when {
            n == 0 -> 0
            n == 1 -> 1
            n == 2 -> 1
            else -> {
                var cache = Triple(0,1,1)
                for (i in 3..n) {
                    cache = Triple(cache.second, cache.third, cache.first + cache.second + cache.third)
                }
                return cache.third
            }
        }
    }
}

fun main() {
    val solution = Solution1137()
    check(solution.tribonacci(4) == 4) { "testing1 wrong result" }
    check(solution.tribonacci(25) == 1389537) { "testing2 wrong result" }
}
