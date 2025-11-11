package com.leetcode.solution.presum

class Solution3728 {
    fun countStableSubarrays(capacity: IntArray): Long {
        val cnt = mutableMapOf<Pair<Int, Long>,Int>()
        var ps = capacity[0].toLong()
        var res = 0L
        for (i in 0 until capacity.lastIndex) {
            val last = capacity[i]
            val cur = capacity[i + 1]
            res += cnt.getOrDefault(Pair(cur, ps), 0)
            cnt[Pair(last, ps + last)] = cnt.getOrDefault(Pair(last, ps + last), 0) + 1
            ps += cur
        }
        return res
    }

    // TLE
    fun countStableSubarrays1(capacity: IntArray): Long {
        val m = mutableMapOf<Int, MutableList<Int>>()
        val ps = mutableListOf<Long>()
        var res = 0L
        for ((i, x) in capacity.withIndex()) {
            if (!m.contains(x)) {
                m[x] = mutableListOf()
            }
            else {
                for (j in m[x]!!) {
                    if (i - j > 1 && ps[i - 1] == x + ps[j]) {
                        res++
                    }
                }
            }
            ps.add(x + if (ps.isEmpty()) 0L else ps.last())
            m[x]!!.add(i)
        }
        return res
    }
}

fun main() {
    val solution = Solution3728()
    check(solution.countStableSubarrays(intArrayOf(536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912,536870912)) == 10L) {"test4"}
    check(solution.countStableSubarrays(intArrayOf(9,3,3,3,9)) == 2L) {"test1"}
    check(solution.countStableSubarrays(intArrayOf(1,2,3,4,5)) == 0L) {"test2"}
    check(solution.countStableSubarrays(intArrayOf(-4,4,0,0,-8,-4)) == 1L) {"test3"}
}
