package com.leetcode.solution

class Solution3226 {
    fun minChanges(n: Int, k: Int): Int {
        if (n and k != k)
            return -1
        return (n xor k).countOneBits()
    }
}

fun main() {
    val solution = Solution3226()
    check(solution.minChanges(13,4) == 2) {"test1 wrong result"}
    check(solution.minChanges(21,21) == 0) {"test2 wrong result"}
    check(solution.minChanges(14,13) == -1) {"test3 wrong result"}
}