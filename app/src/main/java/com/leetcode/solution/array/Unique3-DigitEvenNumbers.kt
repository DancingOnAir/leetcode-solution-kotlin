package com.leetcode.solution.array

class Solution3483 {
    fun totalNumbers(digits: IntArray): Int {
        val res = mutableSetOf<Int>()
        for (i in digits.indices.filter { digits[it] != 0 })
            for (j in digits.indices.filter { it != i })
                for (k in digits.indices.filter { it != i && it != j })
                    res.add(digits[i] * 100 + digits[j] * 10 + digits[k])
        return res.filter { it.toString().length == 3 && it % 2 == 0 }.size
    }
}

fun main() {
    val solution = Solution3483()
    check(solution.totalNumbers(intArrayOf(1,2,3,4)) == 12) {"testing1 wrong result"}
    check(solution.totalNumbers(intArrayOf(0,2,2)) == 2) {"testing2 wrong result"}
    check(solution.totalNumbers(intArrayOf(6,6,6)) == 1) {"testing3 wrong result"}
    check(solution.totalNumbers(intArrayOf(1,3,5)) == 0) {"testing4 wrong result"}
}