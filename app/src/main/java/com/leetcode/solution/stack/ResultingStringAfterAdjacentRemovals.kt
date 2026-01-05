package com.leetcode.solution.stack

import kotlin.math.abs

class Solution3561 {
    fun resultingString(s: String): String {
        val stk = mutableListOf<Char>()
        for (c in s) {
            if (stk.isNotEmpty()) {
                val diff = abs(stk.last() - c)
                if (diff == 1 || diff == 25) {
                    stk.removeAt(stk.lastIndex)
                    continue
                }
            }
            stk.add(c)
        }
        return stk.joinToString("")
    }
}

fun main() {
    val solution = Solution3561()
//    check(solution.resultingString("abc") == "c") {"test1"}
    check(solution.resultingString("adcb") == "") {"test2"}
    check(solution.resultingString("zadb") == "db") {"test3"}
}
