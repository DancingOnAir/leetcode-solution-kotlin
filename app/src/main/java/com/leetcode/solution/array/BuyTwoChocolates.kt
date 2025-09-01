package com.leetcode.solution.array

class Solution2706 {
    fun buyChoco(prices: IntArray, money: Int): Int {
        return prices.sorted().take(2).sum().let { if (it > money) money else money - it }
    }

    fun buyChoco1(prices: IntArray, money: Int): Int {
        prices.sort()
        val mi = prices[0] + prices[1]
        return if (mi > money) money else money - mi
    }
}

fun main() {
    val solution = Solution2706()
    check(solution.buyChoco(intArrayOf(1,2,2), 3) == 0) {"testing1 wrong result"}
    check(solution.buyChoco(intArrayOf(3,2,3), 3) == 3) {"testing2 wrong result"}
}
