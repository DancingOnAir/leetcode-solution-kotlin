package com.leetcode.solution.presum

import kotlin.math.max

class Solution3713 {
    // brute force
    fun longestBalanced(s: String): Int {
        var res = 0
        for (i in 0..s.lastIndex) {
            val cnt = mutableMapOf<Char, Int>()
            for (j in i..s.lastIndex) {
                cnt[s[j]] = cnt.getOrDefault(s[j], 0) + 1
                if (cnt.values.toSet().size == 1) {
                    res = max(res, j - i + 1)
                }
            }
        }
        return res
    }

    fun longestBalanced1(s: String): Int {
        val ps = mutableListOf<MutableList<Int>>()
        val cnt = MutableList(26) {0}
        ps.add(cnt.toMutableList())
        for (c in s) {
            cnt[c - 'a']++
            ps.add(cnt.toMutableList())
        }

        var res = 0
        for (i in 0..ps.lastIndex - 1) {
            for (j in i + 1..ps.lastIndex) {
                var diff = Int.MIN_VALUE
                var flag = true
                for (k in 0..25) {
                    if (ps[j][k] - ps[i][k] != 0) {
                        if (diff == Int.MIN_VALUE) {
                            diff = ps[j][k] - ps[i][k]
                        }
                        else if (ps[j][k] - ps[i][k] != diff) {
                            flag = false
                            break
                        }
                    }
                }
                if (flag) {
                    res = max(res, j - i)
                }
            }
        }

        return res
    }
}

fun main() {
    val solution = Solution3713()
    check(solution.longestBalanced("abbac") == 4) {"test1"}
    check(solution.longestBalanced("zzabccy") == 4) {"test2"}
    check(solution.longestBalanced("aba") == 2) {"test3"}
}
