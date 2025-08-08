package com.leetcode.solution.string

import kotlin.math.max

class Solution3541 {
    // concise
    fun maxFreqSum(s: String): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val freq = s.groupingBy { it }.eachCount()
        val mx1 = freq.filterKeys { it in vowels }.values.maxOrNull()?:0
        val mx2 = freq.filterKeys { it !in vowels }.values.maxOrNull()?:0
        return mx1 + mx2
    }

    fun maxFreqSum1(s: String): Int {
        val freq = s.groupingBy { it }.eachCount()
        var mx1 = 0
        var mx2 = 0
        for ((c, x) in freq) {
            if (c in "aeiou")
                mx1 = max(mx1, x)
            else
                mx2 = max(mx2, x)
        }

        return mx1 + mx2
    }
}

fun main() {
    val solution = Solution3541()
    check(solution.maxFreqSum("successes") == 6) {"test1 wrong result"}
    check(solution.maxFreqSum("aeiaeia") == 3) {"test2 wrong result"}
}