package com.leetcode.solution.greedy

class Solution3800 {
    // s[i]=0，t[i]=1的集合算a
    // s[i]=1，t[i]=0的集合算b
    // if (a < b)
    // 只用flipCost: (a + b) * flipCost
    // 只用swapCost, flipCost: if (swapCost < 2 * flipCost): swapCost * a + (b - a) * flipCost
    // 全部使用: crossCost不影响a + b的结果
    fun minimumCost(s: String, t: String, flipCost: Int, swapCost: Int, crossCost: Int): Long {
//        val x = s.toLong(2)
//        val y = t.toLong(2)
//        var a = (x.inv().and(y)).countOneBits().toLong()
//        var b = (x.and(y.inv())).countOneBits().toLong()
        require(s.length == t.length) { "s and t must have the same length" }
        var a = 0L
        var b = 0L
        for (i in 0..s.lastIndex) {
            when {
                s[i] == '1' && t[i] == '0' -> ++a
                s[i] == '0' && t[i] == '1' -> ++b
            }
        }

        if (a > b)
            a = b.also { b = a }

        val res1 = (a + b) * flipCost
        val res2 = (b - a) * flipCost + a * swapCost
        val q = (a + b) / 2
        val r = (a + b) % 2
        val res3 = (q - a) * crossCost + q * swapCost + r * flipCost
        return minOf(res1, res2, res3)
    }
}

fun main() {
    val solution = Solution3800()
    check(solution.minimumCost("10111101011111101010000101000001", "00000101111001111110000101111000", 3, 7, 10) == 39L) {"test4"}
    check(solution.minimumCost("01000", "10111", 10, 2, 2) == 16L) {"test1"}
    check(solution.minimumCost("001", "110", 2, 100, 100) == 6L) {"test2"}
    check(solution.minimumCost("1010", "1010", 5, 5, 5) == 0L) {"test3"}
}
