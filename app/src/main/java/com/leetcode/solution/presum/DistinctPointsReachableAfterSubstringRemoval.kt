package com.leetcode.solution.presum

class Solution3694 {
    fun distinctPoints(s: String, k: Int): Int {
        val ps = mutableSetOf(Pair(0, 0))
        val dirs = mapOf(
            Pair('U', Pair(0, 1)),
            Pair('D', Pair(0, -1)),
            Pair('L', Pair(-1, 0)),
            Pair('R', Pair(1, 0))
        )

        var x = 0
        var y = 0
        for ((i, c) in s.withIndex()) {
            if (i - k >= 0) {
                val (inX, inY) = dirs[c]!!
                val (outX, outY) = dirs[s[i - k]]!!
                x += inX - outX
                y += inY - outY
                ps.add(Pair(x, y))
            }
        }
        return ps.size
    }
}

fun main() {
    val solution = Solution3694()
    check(solution.distinctPoints("LUL", 1) == 2) {"test1"}
    check(solution.distinctPoints("UDLR", 4) == 1) {"test2"}
    check(solution.distinctPoints("UU", 1) == 1) {"test3"}
}
