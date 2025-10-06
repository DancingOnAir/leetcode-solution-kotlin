package com.leetcode.solution.slidingWindow

class Solution3679 {
    fun minArrivalsToDiscard(arrivals: IntArray, w: Int, m: Int): Int {
        var res = 0
        var l = 0
        var cnt = mutableMapOf<Int, Int>()
        for ((r, x) in arrivals.withIndex()) {
            if (cnt.getOrDefault(x, 0) == m) {
                arrivals[r] = 0
                res++
            } else {
                cnt[x] = cnt.getOrDefault(x, 0) + 1
            }

            if (r - l + 1 == w) {
                cnt[arrivals[l]] = cnt.getOrDefault(arrivals[l], 0) - 1
                l += 1
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution3679()
    check(solution.minArrivalsToDiscard(intArrayOf(1,2,1,3,1),4, 2) == 0) { "test1 wrong result" }
    check(solution.minArrivalsToDiscard(intArrayOf(1,2,3,3,3,4),3, 2) == 1) { "test2 wrong result" }
}
