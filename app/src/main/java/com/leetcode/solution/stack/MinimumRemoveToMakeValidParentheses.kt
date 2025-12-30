package com.leetcode.solution.stack

import android.os.Build
import androidx.annotation.RequiresApi

class Solution1249 {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun minRemoveToMakeValid(s: String): String {
        var stk = mutableListOf<Int>()
        for ((i, c) in s.withIndex()) {
            if (c == '(')
                stk.add(i)
            if (c == ')') {
                if (stk.isNotEmpty() && s[stk.last()] == '(') {
                    stk.removeLast()
                }
                else {
                    stk.add(i)
                }
            }
        }

        var res = ""
        for ((i, c) in s.withIndex()) {
            if (i !in stk)
                res += c
        }
        return res
    }
}

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
fun main() {
    val solution = Solution1249()
    check(solution.minRemoveToMakeValid("lee(t(c)o)de)") == "lee(t(c)o)de") {"test1"}
    check(solution.minRemoveToMakeValid("a)b(c)d") == "ab(c)d") {"test2"}
    check(solution.minRemoveToMakeValid("))((") == "") {"test3"}
}
