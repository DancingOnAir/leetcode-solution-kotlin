package com.leetcode.solution.array

class Solution3527 {
    fun findCommonResponse(responses: List<List<String>>): String {
        return responses
            .flatMap { it.distinct() }
            .groupingBy { it }
            .eachCount()
            .maxWith(compareBy<Map.Entry<String, Int>> { it.value }.thenByDescending { it.key })
            .key
    }

    fun findCommonResponse1(responses: List<List<String>>): String {
        val m = mutableMapOf<String, Int>()
        for (response in responses) {
            for (w in response.toSet()) {
                m[w] = m.getOrDefault(w, 0) + 1
            }
        }

        var res = ""
        var mx = 0
        for ((k, v) in m) {
            if (mx < v || (mx == v && res > k)) {
                res = k
                mx = v
            }
        }
        return res
    }
}

fun main() {
    val solution = Solution3527()
    check(solution.findCommonResponse(listOf(listOf("good","ok","good","ok"), listOf("ok","bad","good","ok","ok"), listOf("good"), listOf("bad"))) == "good")
    check(solution.findCommonResponse(listOf(listOf("good","ok","good"), listOf("ok","bad"), listOf("bad","notsure"), listOf("great","good"))) == "bad")
}
