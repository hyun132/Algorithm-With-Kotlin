import java.io.BufferedReader
import java.io.InputStreamReader

var visited = longArrayOf()
var graph = HashMap<Int, List<Int>>()
var takes = listOf<Int>()
var answer = 0L
var indgrees = mutableListOf<Int>()
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    val case = readLine().trim().toInt()
    for (i in 0 until case) {
        val numsAndVer = readLine().split(' ').map { it.toInt() }
        takes = listOf(0) + readLine().split(' ').map { it.toInt() }
        answer = 0
        visited = LongArray(numsAndVer[0] + 1)
        indgrees = MutableList(numsAndVer[0] + 1, { 0 })

        graph = HashMap<Int, List<Int>>()

        for (j in 0 until numsAndVer[1]) {
            val rule = readLine().split(' ').map { it.toInt() }
            indgrees[rule[1]] = indgrees[rule[1]] + 1
            if (!graph.containsKey(rule[1])) graph[rule[1]] = mutableListOf()
            if (!graph.containsKey(rule[0])) graph[rule[0]] = mutableListOf(rule[1])
            else graph[rule[0]] = graph[rule[0]]!! + rule[1]
        }

        val dest = readLine().toInt()

        val dq = ArrayDeque<Int>()

        for (n in 1 .. numsAndVer[0]) {
            if (indgrees[n] == 0) {
                dq.add(n)
                visited[n] = takes[n].toLong()
            }
        }

        while (dq.isNotEmpty()) {
            val cur = dq.removeFirst()
            if (cur == dest) continue
            graph[cur]?.let {
                for (nxt in it) {
                    if (indgrees[nxt] < 1) continue
                    indgrees[nxt] -= 1
                    if (indgrees[nxt] == 0) dq.add(nxt)
                    if (visited[nxt] < visited[cur] + takes[nxt]) {
                        visited[nxt] = visited[cur] + takes[nxt]
                    }
                }
            }
            graph[cur] = listOf()
        }
        println(visited[dest])
    }
}

