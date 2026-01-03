package com.leetcode.solution.stack

class Solution3703 {
    fun removeSubstring(s: String, k: Int): String {
        val stk = mutableListOf<Pair<Char, Int>>()
        for (c in s) {
            if (stk.isNotEmpty() && stk.last().first == c) {
                val (ch, cnt) = stk.removeAt(stk.lastIndex)
                stk.add(c to cnt + 1)
            }
            else {
                stk.add(c to 1)
            }

            if (c == ')' && stk.size > 1) {
                val lastCount = stk.last().second
                val topCount = stk[stk.lastIndex - 1].second

                if (lastCount == k && topCount >= k) {
                    stk.removeAt(stk.lastIndex)
                    var (topChar, newTopCount) = stk.removeAt(stk.lastIndex)
                    newTopCount -= k
                    if (newTopCount > 0) {
                        stk.add(topChar to newTopCount)
                    }
                }
            }
        }

        return buildString {
            for ((c, x) in stk) {
                repeat(x) {
                    append(c)
                }
            }
        }
    }

    // TLM
    fun removeSubstring1(s: String, k: Int): String {
        val stk = mutableListOf<Char>()
        val p = "(".repeat(k) + ")".repeat(k)
        val n = p.length
        for (c in s) {
            stk.add(c)

            if (stk.size >= n && stk.subList(stk.size - n, stk.size).joinToString("") == p) {
                var i = n
                while (i > 0) {
                    stk.removeAt(stk.lastIndex)
                    --i
                }
            }
        }
        return stk.joinToString("")
    }
}

fun main() {
    val solution = Solution3703()
    check(solution.removeSubstring("(())", 1) == "") {"test1"}
    check(solution.removeSubstring("(()(", 1) == "((") {"test2"}
    check(solution.removeSubstring("((()))()()()", 3) == "()()()") {"test3"}
}
