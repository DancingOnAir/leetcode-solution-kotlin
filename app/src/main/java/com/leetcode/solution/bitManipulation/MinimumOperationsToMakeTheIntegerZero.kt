package com.leetcode.solution.bitManipulation

class Solution2749 {
    fun makeTheIntegerZero(num1: Int, num2: Int): Int {
        var k = 1
        while (true) {
            val x = num1.toLong() - k.toLong() * num2.toLong()
            if (k > x)
                return -1
            if (k >= x.countOneBits())
                return k
            k++
        }
    }
}

fun main() {
    val solution = Solution2749()
    check(solution.makeTheIntegerZero(112577768, -501662198) == 16) {"test3 wrong result"}
    check(solution.makeTheIntegerZero(3, -2) == 3) {"test1 wrong result"}
    check(solution.makeTheIntegerZero(5, 7) == -1) {"test2 wrong result"}
}
