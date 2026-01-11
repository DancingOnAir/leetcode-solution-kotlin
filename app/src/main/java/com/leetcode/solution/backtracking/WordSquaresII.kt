package com.leetcode.solution.backtracking

class Solution3799 {
    // dfs
    fun wordSquares(words: Array<String>): List<List<String>> {
        words.sort()
        val res = mutableListOf<List<String>>()
        val path = IntArray(4)
        val seen = BooleanArray(words.size) { false }

        dfs(words, 0, path, seen, res)
        return res
    }

    fun dfs(words: Array<String>, i: Int, path: IntArray, seen: BooleanArray, res: MutableList<List<String>>) {
        if (i == 4) {
            val top = words[path[0]]
            val left = words[path[1]]
            val right = words[path[2]]
            val bottom = words[path[3]]
            if (top[0] == left[0] && top[3] == right[0] && bottom[0] == left[3] && bottom[3] == right[3]) {
                res.add(listOf(top, left, right, bottom))
            }
            return
        }

        for (j in 0..words.lastIndex) {
            if (!seen[j]) {
                path[i] = j
                seen[j] = true
                dfs(words, i + 1, path, seen, res)
                seen[j] = false
            }
        }
    }

    // TLS
    fun wordSquares1(words: Array<String>): List<List<String>> {
        fun <T> List<T>.permutations(): List<List<T>> {
            if (isEmpty())
                return listOf(emptyList())
            return indices.flatMap { i ->
                val cur = this[i]
                val rest = this.subList(0, i) + this.subList(i + 1, size)
                rest.permutations().map { listOf(cur) + it }
            }
        }

        words.sort()
        val res = mutableSetOf<List<String>>()
        for ((top, left, right, bottom) in words.toList().permutations()) {
            if (top[0] == left[0] && top[3] == right[0] && bottom[0] == left[3] && bottom[3] == right[3]) {
                res.add(listOf(top, left, right, bottom))
            }
        }
        return res.toList()
    }
}

fun main() {
    val solution = Solution3799()
    check(solution.wordSquares(arrayOf("able","area","echo","also")) == listOf(listOf("able","area","echo","also"),
        listOf("area","able","also","echo"))) {"test1"}
    check(solution.wordSquares(arrayOf("code","cafe","eden","edge")) == emptyList<List<String>>()) {"test2"}
    check(solution.wordSquares(arrayOf("akka","aoov","lvmm","xvvv","ahhx","cvli")) == listOf(listOf("ahhx","akka","xvvv","aoov"), listOf("akka","ahhx","aoov","xvvv"))) {"test3"}
}

