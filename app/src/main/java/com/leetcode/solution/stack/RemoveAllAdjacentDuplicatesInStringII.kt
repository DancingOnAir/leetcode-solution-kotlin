package com.leetcode.solution.stack

class Solution1209 {
    fun removeDuplicates(s: String, k: Int): String {
        val stk = mutableListOf<Pair<Char, Int>>()
        for (c in s) {
            if (stk.isNotEmpty() && stk.last().first == c) {
                val (lastChar, lastCount) = stk.removeAt(stk.lastIndex)
                stk.add(lastChar to lastCount + 1)
            }
            else {
                stk.add(c to 1)
            }

            if (stk.last().second == k) {
                stk.removeAt(stk.lastIndex)
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
}

fun main() {
    val solution = Solution1209()
    check(solution.removeDuplicates("abcd", 2) == "abcd") {"test1"}
    check(solution.removeDuplicates("deeedbbcccbdaa", 3) == "aa") {"test2"}
    check(solution.removeDuplicates("pbbcggttciiippooaais", 2) == "ps") {"test3"}
}
