import java.lang.Integer.max

fun main() {
    solution(8, arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10)))
}

fun solution(k: Int, dungeons: Array<IntArray>): Int {
    return dfs(k, dungeons, mutableListOf())
}

fun dfs(tiredness: Int, dungeons: Array<IntArray>, visited: MutableList<Int>): Int {
    if (visited.size == dungeons.size) return visited.size

    var maxVisitedCase = visited.size
    for (i in dungeons.indices) {
        if (tiredness >= dungeons[i][0]) {
            if (!visited.contains(i)) {
                val tempaArr = visited.toMutableList()
                tempaArr.add(i)
                maxVisitedCase = max(maxVisitedCase, dfs(tiredness - dungeons[i][1], dungeons, tempaArr))
            }
        }
    }
    return maxVisitedCase
}
