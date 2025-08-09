package com.leetcode.solution.string

class Solution3545 {
    fun minDeletion(s: String, k: Int): Int {
        val m = hashMapOf<Char, Int>()
        for (c in s) {
            m[c] = m.getOrDefault(c, 0) + 1
        }

        if (m.keys.size <= k)
            return 0

        var res = 0
        val sorted = m.entries.sortedBy { it.value }
        var n = sorted.size
        for ((_, v) in sorted) {
            if (n <= k)
                return res
            res += v
            n--
        }
        return res
    }

    fun minDeletion1(s: String, k: Int): Int {
        var freq = s.groupingBy { it }.eachCount().values.sorted()
        return freq.take(if (freq.size <= k) 0 else freq.size-k).sum()
    }
}

fun main() {
    val solution = Solution3545()
    check(solution.minDeletion("abc", 2) == 1) {"test1 wrong result"}
    check(solution.minDeletion("aabb",2) == 0) {"test2 wrong result"}
    check(solution.minDeletion("yyyzz",1) == 2) {"test3 wrong result"}
}
