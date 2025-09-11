package com.leetcode.solution.array

class Solution2144 {
    fun minimumCost(cost: IntArray): Int {
        cost.sortDescending()
        var res = 0
        for (i in cost.indices) {
            if (i % 3 != 2)
                res += cost[i]
        }
        return res
    }

    fun minimumCost1(cost: IntArray): Int {
        cost.sortDescending()
        var res = 0
        for (i in 0 until cost.size step 3) {
            res += cost[i]
            if (i + 1 < cost.size)
                res += cost[i + 1]
        }
        return res
    }
}

fun main() {
    val solution = Solution2144()
    check(solution.minimumCost(intArrayOf(1,2,3)) == 5) {"testing1 wrong result"}
    check(solution.minimumCost(intArrayOf(6,5,7,9,2,2)) == 23) {"testing2 wrong result"}
    check(solution.minimumCost(intArrayOf(5,5)) == 10) {"testing3 wrong result"}
}
