package com.leetcode.solution.math

class Solution2806 {
    fun accountBalanceAfterPurchase(purchaseAmount: Int): Int {
        return 100 - 10 * (Math.round(purchaseAmount.toDouble() / 10)).toInt()
    }

    fun accountBalanceAfterPurchase1(purchaseAmount: Int): Int {
        return 100 - 10 * (purchaseAmount / 10 + (if (purchaseAmount % 10 > 4) 1 else 0))
    }
}

fun main() {
    val solution = Solution2806()
    check(solution.accountBalanceAfterPurchase(11) == 90) {"wrong result"}
    check(solution.accountBalanceAfterPurchase(9) == 90) {"wrong result"}
    check(solution.accountBalanceAfterPurchase(15) == 80) {"wrong result"}
    check(solution.accountBalanceAfterPurchase(10) == 90) {"wrong result"}
}
