package leetcode.tryeasyproblem

import kotlin.math.abs
import kotlin.math.min

class Splitting_the_power_grid_in_half {

    var answer = 0
    lateinit var arr: MutableList<Node>
    lateinit var visited: MutableList<Boolean>
    var size = 0
    fun solution(n: Int, wires: Array<IntArray>): Int {
        answer = n
        size = n
        arr = MutableList<Node>(101) { Node(it) }
        visited = MutableList<Boolean>(101) { false }

        for (nxt in wires) {
            arr[nxt[0]].child.add(arr[nxt[1]])
            arr[nxt[1]].child.add(arr[nxt[0]])
        }

        find(arr[wires[0][0]])

        return answer
    }

    fun find(current: Node): Int {
        if (visited[current.no]) return 0
        visited[current.no] = true
        var value = 1
        for (nxt in current.child) {
            value += find(nxt)
        }
        answer = min(abs(size - value * 2), answer)
        return value
    }

    data class Node(
            var no: Int,
            var child: MutableList<Node> = mutableListOf()
    )
}

fun main() {
    val sol = Splitting_the_power_grid_in_half()
    println(sol.solution(9, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5), intArrayOf(4, 6), intArrayOf(4, 7), intArrayOf(7, 8), intArrayOf(7, 9))))
    println(sol.solution(7, arrayOf(intArrayOf(1, 2), intArrayOf(2, 7), intArrayOf(3, 7), intArrayOf(4, 5), intArrayOf(4, 6), intArrayOf(4, 7), intArrayOf(7, 8), intArrayOf(7, 9))))
    println(sol.solution(4, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))))
}