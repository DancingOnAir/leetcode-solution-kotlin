package com.leetcode.solution.stack

import kotlin.math.min

class Solution0301 {
    fun removeInvalidParentheses(s: String): List<String> {
        val res = mutableSetOf<String>()
        var openBracket = 0
        var closeBracket = 0
        var left = 0
        var right = 0
        for (c in s) {
            if (c == '(') {
                ++openBracket
                ++left
            }
            else if (c == ')') {
                if (left > 0)
                    --left
                else
                    ++right
                ++closeBracket
            }
        }
        val mx = min(openBracket, closeBracket)
        val len = s.length - left - right

        fun dfs(u: Int, cur: String, l: Int, r: Int, score: Int) {
            if (l < 0 || r < 0 || score < 0 || score > mx)
                return
            if (l == 0 && r == 0) {
                if (cur.length == len)
                    res.add(cur)
            }
            if (u == s.length)
                return

            if (s[u] == '(') {
                dfs(u + 1, cur + s[u], l, r, score + 1)
                dfs(u + 1, cur, l - 1, r, score)
            }
            else if (s[u] == ')') {
                dfs(u + 1, cur + s[u], l, r, score - 1)
                dfs(u + 1, cur, l, r - 1, score)
            }
            else {
                dfs(u + 1, cur + s[u], l, r, score)
            }
        }

        dfs(0, "", left, right, 0)
        return res.toList()
    }
}

fun main() {
    val solution = Solution0301()
    check(solution.removeInvalidParentheses("()())()") == listOf("(())()","()()()")) {"test1"}
    check(solution.removeInvalidParentheses("(a)())()") == listOf("(a())()","(a)()()")) {"test2"}
    check(solution.removeInvalidParentheses(")(") == listOf("")) {"test3"}
}
