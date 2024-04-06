import java.io.BufferedReader
import java.io.InputStreamReader

var answer = mutableSetOf<Int>()
var n = 0
var arr = arrayOf(1,5,10,50)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().trim().toInt()

    dfs(0,0, 0)

    println(answer.size)
}

fun dfs(start:Int, depth: Int, sum: Int): Unit {

    if (depth == n) {
        answer.add(sum)
        return
    }

    for (i in start until 4) {
        dfs(i, depth + 1, sum + arr[i])
    }
}
