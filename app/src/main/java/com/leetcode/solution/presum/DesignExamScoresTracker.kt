package com.leetcode.solution.presum

class ExamTracker3709() {
    val ps: MutableList<Long> = mutableListOf(0L)
    val t: MutableList<Int> = mutableListOf()

    fun record(time: Int, score: Int) {
        t.add(time)
        ps.add(score + ps.last())
    }

    fun totalScore(startTime: Int, endTime: Int): Long {
        var s = t.binarySearch(startTime)
        var e = t.binarySearch(endTime)
        if (s < 0)
            s = -(s + 1)
        if (e < 0)
            e = -(e + 1) - 1
        if (s > e)
            return 0L
        return ps[e + 1] - ps[s]
    }
}

fun main() {
    val examTracker = ExamTracker3709()
    examTracker.record(1, 98)
    check(examTracker.totalScore(1,1) == 98L) {"test1"}
    examTracker.record(5, 99)
    check(examTracker.totalScore(1,3) == 98L) {"test2"}
    check(examTracker.totalScore(1,5) == 197L) {"test3"}
    check(examTracker.totalScore(3,4) == 0L) {"test4"}
    check(examTracker.totalScore(2,5) == 99L) {"test5"}
}
