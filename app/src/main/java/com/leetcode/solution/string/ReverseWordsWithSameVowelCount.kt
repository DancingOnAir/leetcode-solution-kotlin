package com.leetcode.solution.string

class Solution3775 {
    fun reverseWords(s: String): String {
        val res = mutableListOf<String>()
        var first = -1
        for (w in s.split(' ')) {
            val cnt = w.count { it in "aeiou" }
            if (first == -1) {
                first = cnt
                res.add(w)
            }
            else {
                if (cnt == first) {
                    res.add(w.reversed())
                }
                else {
                    res.add(w)
                }
            }
        }

        return res.joinToString(" ")
    }
}

fun main() {
    val solution = Solution3775()
    check(solution.reverseWords("cat and mice") == "cat dna mice") {"test1"}
    check(solution.reverseWords("book is nice") == "book is ecin") {"test2"}
    check(solution.reverseWords("banana healthy") == "banana healthy") {"test2"}
}