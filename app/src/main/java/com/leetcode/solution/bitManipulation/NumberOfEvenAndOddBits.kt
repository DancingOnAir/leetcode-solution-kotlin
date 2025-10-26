package com.leetcode.solution.bitManipulation

class Solution2595 {
    fun evenOddBit(n: Int): IntArray {
        var even = 0
        var odd = 0
        var i = 0
        while (n.shr(i) != 0) {
            if (n and (1.shl(i)) > 0) {
                if (i % 2 == 0)
                    even++
                else
                    odd++
            }
            i++
        }
        return intArrayOf(even, odd)
    }
}

fun main() {
    val solution = Solution2595()
    check(solution.evenOddBit(50).contentEquals(intArrayOf(1,2))) {"test1 wrong result"}
    check(solution.evenOddBit(2).contentEquals(intArrayOf(0,1))) {"test2 wrong result"}
}
