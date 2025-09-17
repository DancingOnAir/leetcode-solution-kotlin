package com.leetcode.solution.array

class Solution3537 {
    fun specialGrid(n: Int): Array<IntArray> {
        val res = Array(1 shl n) { IntArray(1 shl n) {0} }
        var value = 0

        fun dfs(t: Int, b: Int, l: Int, r: Int) {
            if (b == t + 1) {
                res[t][l] = value
                value++
                return
            }

            val m = (b - t) / 2
            dfs(t, t + m, l + m, r)
            dfs(t + m, b, l + m, r)
            dfs(t + m, b, l, l + m)
            dfs(t, t + m, l, l + m)
        }

        dfs(0, 1 shl n, 0, 1 shl n)
        return res
    }
}

fun main() {
    val solution = Solution3537()
    check(solution.specialGrid(0).contentDeepEquals(arrayOf(intArrayOf(0)))) { "test1 wrong result" }
    check(solution.specialGrid(1).contentDeepEquals(arrayOf(intArrayOf(3,0), intArrayOf(2,1)))) { "test2 wrong result" }
    check(solution.specialGrid(2).contentDeepEquals(arrayOf(intArrayOf(15,12,3,0), intArrayOf(14,13,2,1), intArrayOf(11,8,7,4), intArrayOf(10,9,6,5)))) { "test3 wrong result" }
}
