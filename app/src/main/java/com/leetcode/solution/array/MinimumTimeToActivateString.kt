package com.leetcode.solution.array

class Solution3639 {
    fun minTime(s: String, order: IntArray, k: Int): Int {
        val n = s.length
        var cnt = n * (n + 1) / 2
        if (cnt < k)
            return -1
        val pre = IntArray(n + 2) { it -> it - 1}
        val nxt = IntArray(n + 2) { it -> it + 1}

        for (t in n - 1 downTo 0) {
            val i = order[t]
            val l = pre[i]
            val r = nxt[i]
            cnt -= (i - l) * (r - i)
            if (cnt < k)
                return t
            nxt[l] = r
            pre[r] = l
        }
        return -1
    }
}

fun main() {
    val solution = Solution3639()
    check(solution.minTime("abc", intArrayOf(0,1,2), 2) == 0) {"testing1 wrong result"}
    check(solution.minTime("cat", intArrayOf(0,2,1), 6) == 2) {"testing2 wrong result"}
    check(solution.minTime("xy", intArrayOf(0,1), 4) == -1) {"testing3 wrong result"}
}
