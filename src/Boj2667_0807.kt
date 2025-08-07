import java.io.BufferedReader
import java.io.InputStreamReader

val buildings = arrayListOf<Int>()
val dy = arrayOf(1,0,-1,0)
val dx = arrayOf(0,-1,0,1)
var n = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine()!!.trim().toInt()
    val map = Array<Array<Int>>(n) { Array<Int>(n) { 0 } }
    for (i in 0 until n){
        val row = readLine()!!.trimEnd().map { it-'0' }.toTypedArray()
        map[i] = row
    }

    for (i in 0 until n){
        for (j in 0 until n){
            if (map[i][j] == 0) continue
            bfs(i,j,map)
        }
    }
    val sb = StringBuilder()
    sb.append("${buildings.size}\n")
    for (num in buildings.sorted()){
        sb.append("$num\n")
    }
    println(sb.toString())
}

fun bfs(y: Int, x: Int, map: Array<Array<Int>>) {

    val q = ArrayDeque<Pair<Int, Int>>()
    var ny = 0
    var nx = 0
    var count =0
    q.add(Pair(y,x))
    map[y][x] = 0
    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        count++
        for (i in 0 until 4){
            ny = dy[i]+cur.first
            nx = dx[i]+cur.second
            if (isInBound(ny,nx) && map[ny][nx]==1){
                q.add(Pair(ny,nx))
                map[ny][nx] = 0
            }
        }
    }
    buildings.add(count)
}

fun isInBound(y:Int,x:Int): Boolean{
    return y>=0 && x>=0 && y<n && x<n
}
