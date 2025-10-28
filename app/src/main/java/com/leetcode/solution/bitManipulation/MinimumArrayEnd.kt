package com.leetcode.solution.bitManipulation

class Solution3133 {
    fun minEnd(n: Int, x: Int): Long {
        val nBitsReversed = (n - 1).toString(2).reversed()
        val xBitsReversed = x.toString(2).reversed()

        var nBitIndex = 0
        val res = StringBuilder()
        for (bit in xBitsReversed) {
            if (bit == '0' && nBitIndex < nBitsReversed.length) {
                res.append(nBitsReversed[nBitIndex++])
            } else {
                res.append(bit)
            }
        }

        if (nBitIndex < nBitsReversed.length) {
            res.append(nBitsReversed.substring(nBitIndex))
        }

        return res.toString().reversed().toLong(2)
    }

    fun minEnd1(n: Int, x: Int): Long {
        val nBit = (n - 1).toString(2).reversed()
        val xBit = x.toString(2).reversed().toMutableList()
        var idx = 0
        for (i in 0 .. xBit.lastIndex) {
            if (xBit[i] == '0') {
                xBit[i] = nBit[idx++]
                if (idx == nBit.length) {
                    return xBit.reversed().joinToString("").toLong(2)
                }
            }
        }
        return (xBit.joinToString("") + nBit.substring(idx)).reversed().toLong(2)
    }
}

fun main() {
    val solution = Solution3133()
    // 4 - 100
    check(solution.minEnd(3,4) == 6L) {"test1 wrong result"}
    check(solution.minEnd(2,7) == 15L) {"test2 wrong result"}
}
