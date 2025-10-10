package com.leetcode.solution.math

class Solution3697 {
    fun decimalRepresentation(n: Int): IntArray {
        val res = mutableListOf<Int>()
        var base = 10
        var target = n
        while (target > 0) {
            val digit = target % base
            if (digit != 0)
                res.add(digit)
            target -= digit
            base *= 10
        }
        return res.toIntArray().reversedArray()
    }
}

fun main() {
    val solution = Solution3697()
    check(solution.decimalRepresentation(537).contentEquals(intArrayOf(500,30,7))) {"test1 wrong result"}
    check(solution.decimalRepresentation(102).contentEquals(intArrayOf(100,2))) {"test2 wrong result"}
    check(solution.decimalRepresentation(6).contentEquals(intArrayOf(6))) {"test3 wrong result"}
}
