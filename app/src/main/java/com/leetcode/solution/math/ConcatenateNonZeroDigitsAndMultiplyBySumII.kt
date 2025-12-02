package com.leetcode.solution.math

class Solution3756 {
    fun sumAndMultiply(s: String, queries: Array<IntArray>): IntArray {
        val res = mutableListOf<Int>()
        val n = s.length
        val preNonZeroCnt = LongArray(n + 1)
        val preNonZeroNum = LongArray(n + 1)
        val preSum = LongArray(n + 1)
        val preMul = LongArray(n + 1)
        preMul[0] = 1L
        val MOD = 1_000_000_007L
        for ((i, c) in s.withIndex()) {
            preMul[i + 1] = (preMul[i] * 10) % MOD
            val x = c.digitToInt()
            preSum[i + 1] = preSum[i] + x
            if (x > 0) {
                preNonZeroCnt[i + 1] = preNonZeroCnt[i] + 1
                preNonZeroNum[i + 1] = (preNonZeroNum[i] * 10 + x) % MOD
            }
            else {
                preNonZeroCnt[i + 1] = preNonZeroCnt[i]
                preNonZeroNum[i + 1] = preNonZeroNum[i]
            }
        }

        for ((l, r) in queries) {
            val diffSum = (preSum[r + 1] - preSum[l] + MOD) % MOD
            val diffX = (preNonZeroNum[r + 1] + MOD - (preNonZeroNum[l] * preMul[(preNonZeroCnt[r + 1] - preNonZeroCnt[l]).toInt()]).mod(MOD)).mod(MOD)

            res.add((diffSum * diffX).mod(MOD).toInt())
        }
        return res.toIntArray()
    }
}

fun main() {
    val solution = Solution3756()
    check(solution.sumAndMultiply("10203004", arrayOf(intArrayOf(0,7), intArrayOf(1,3), intArrayOf(4,6))).contentEquals(intArrayOf(12340, 4, 9))) {"test1"}
    check(solution.sumAndMultiply("1000", arrayOf(intArrayOf(0,3), intArrayOf(1,1))).contentEquals(intArrayOf(1, 0))) {"test2"}
    check(solution.sumAndMultiply("9876543210", arrayOf(intArrayOf(0,9))).contentEquals(intArrayOf(444444137))) {"test3"}
}
