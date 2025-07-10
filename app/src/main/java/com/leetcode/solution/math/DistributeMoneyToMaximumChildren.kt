package com.leetcode.solution.math

import kotlin.math.min

class Solution2591 {
    fun distMoney(money: Int, children: Int): Int {
        if (money < children)
            return -1
        var rest = money - children
        val cnt = min(rest / 7, children)
        rest -= cnt * 7
        if ((children - cnt == 1 && rest == 3) || (children - cnt == 0 && rest > 0))
            return cnt - 1
        return cnt
    }
}

fun main() {
    val solution = Solution2591()
    check(solution.distMoney(20,3) == 1) { "wrong result" }
    check(solution.distMoney(16,2) == 2) { "wrong result" }
}
