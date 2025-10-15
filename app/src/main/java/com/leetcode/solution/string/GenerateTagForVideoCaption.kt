package com.leetcode.solution.string

class Solution3582 {
    fun generateTag(caption: String): String {
        val res = mutableListOf<Char>()
        for (w in caption.split(" ")) {
            for (i in w.indices) {
                if (res.size == 99)
                    break
                if (!w[i].isLetter())
                    continue
                if (res.isEmpty() || i != 0) {
                    res.add(w[i].lowercaseChar())
                } else {
                    res.add(w[i].uppercaseChar())
                }
            }
        }
        return "#" + res.joinToString("")
    }
}

fun main() {
    val solution = Solution3582()
    check(solution.generateTag("Leetcode daily streak achieved") == "#leetcodeDailyStreakAchieved") {"test1 wrong result"}
    check(solution.generateTag("can I Go There") == "#canIGoThere") {"test2 wrong result"}
    check(solution.generateTag("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh") == "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh") {"test3 wrong result"}
}
