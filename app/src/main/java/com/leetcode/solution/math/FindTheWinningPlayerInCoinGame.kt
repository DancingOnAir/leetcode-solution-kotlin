package com.leetcode.solution.math

import kotlin.math.min

class Solution3222 {
    fun winningPlayer(x: Int, y: Int) = when {
        min(x, y / 4) % 2 == 1 -> "Alice"
        else -> "Bob"
    }

    fun winningPlayer2(x: Int, y: Int) = if (min(x, y / 4) % 2 == 1) "Alice" else "Bob"

    fun winningPlayer1(x: Int, y: Int): String {
        if (min(x, y / 4) % 2 == 1) {
            return "Alice"
        }
        return "Bob"
    }
}

fun main() {
    val solution = Solution3222()
    check(solution.winningPlayer(2, 7) == "Alice") {"wrong result"}
    check(solution.winningPlayer(4, 11) == "Bob") {"wrong result"}
}
