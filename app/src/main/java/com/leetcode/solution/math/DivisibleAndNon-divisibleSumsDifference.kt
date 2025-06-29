package com.leetcode.solution.math

class Solution2894 {
    fun differenceOfSums(n: Int, m: Int): Int {
        return (1..n).sumOf { if (it % m != 0) it else -it }
    }

    // brute force
    fun differenceOfSums1(n: Int, m: Int): Int {
        var tot1 = 0
        var tot2 = 0
        for (i in 1 .. n) {
            if (i % m == 0) {
                tot1 += i
            }
            else {
                tot2 += i
            }
        }

        return tot2 - tot1
    }
}

fun main() {
    val solution = Solution2894()
    check(solution.differenceOfSums(10, 3) == 19) {"wrong result"}
    check(solution.differenceOfSums(5, 6) == 15) {"wrong result"}
    check(solution.differenceOfSums(5, 1) == -15) {"wrong result"}
}