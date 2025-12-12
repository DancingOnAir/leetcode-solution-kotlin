package com.leetcode.solution.string

class Solution3517 {
    fun smallestPalindrome(s: String): String {
        val cnt = IntArray(26) {0}
        for (c in s) {
            cnt[c - 'a']++
        }

        var odd = -1
        var res = ""
        for (i in 25 downTo 0) {
            if (cnt[i] % 2 == 1) {
                odd = i
            }

            res += ('a' + i).toString().repeat(cnt[i] / 2)
        }
        return res.reversed() + (if (odd == -1) "" else ('a' + odd).toString()) + res
    }
}

fun main() {
    val solution = Solution3517()
    check(solution.smallestPalindrome("inini") == "inini") {"test4"}
    check(solution.smallestPalindrome("z") == "z") {"test1"}
    check(solution.smallestPalindrome("babab") == "abbba") {"test2"}
    check(solution.smallestPalindrome("daccad") == "acddca") {"test3"}
}
