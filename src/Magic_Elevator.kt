package leetcode.tryeasyproblem

import kotlin.math.min

class Magic_Elevator {

    var answer = Int.MAX_VALUE
    val visited: MutableSet<Int> = mutableSetOf()

    fun solution(storey: Int): Int {
        answer = Int.MAX_VALUE
        visited.clear()
        visited.add(storey)
        dfs(storey, 0)
        return answer
    }

    fun dfs(start: Int, cost: Int) {
        if (start == 0) {
            answer = min(answer, cost)
            return
        }
        if (cost >= answer) return
        var n = start % 10
        var new = start - n
        dfs(new/10, cost + n)

        var new2 = start + 10
        if (new2 > 0) {
            dfs(new2/10, cost + (10 - n))
        }
    }
}

fun main() {
    val me = Magic_Elevator()

    println(me.solution(16))
    print(me.solution(2554))
}