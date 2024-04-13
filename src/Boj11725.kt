import java.io.BufferedReader
import java.io.InputStreamReader

var visited: Array<Boolean> = emptyArray()
var answerArr: Array<Int> = emptyArray()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().trim().toInt()
    val nodes = mutableMapOf<Int, MutableList<Int>>()

    visited = Array<Boolean>(n + 1) { false }
    answerArr = Array<Int>(n + 1) { 1 }
    visited[0] = true

    for (i in 1 until n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        nodes.getOrPut(a) { mutableListOf() }.add(b)
        nodes.getOrPut(b) { mutableListOf() }.add(a)
    }

    visited[1] = true

    val q : ArrayDeque<Int> = ArrayDeque()
    q.add(1)
    while (q.isNotEmpty()) {
        val size= q.size
        for (i in 0 until  size) {
            val c = q.removeFirst()
            visited[c] = true

            for(child in nodes[c]!!){
                if(visited[child]) continue
                visited[child] = true
                q.add(child)
                answerArr[child] = c
            }
        }
    }

    for(i in 2 until n+1){
        println(answerArr[i])
    }

}
