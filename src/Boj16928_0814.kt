import java.io.BufferedReader
import java.io.InputStreamReader

var adjustedArr = IntArray(101)
var visitedCount = IntArray(101){100}
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine().trim().split(" ").map { it.toInt() }
    val n = input[0]
    val m = input[1]
    var i=0
    adjustedArr = IntArray(101){i++}

    for (j in 0 until m+n) {
        val positions = readLine().trim().split(" ").map { it.toInt() }
        adjustedArr[positions[0]] = positions[1]
    }
    dfs(0,1)
    println(visitedCount[100])
}

fun dfs(depth:Int,start:Int){
    if(depth >= 100){
        if (depth == 100){
            visitedCount[100] = minOf( visitedCount[100] , depth)
        }
        return
    }
    val destList = arrayOf(start+1,start+2,start+3,start+4,start+5,start+6).filter { it<=100 }.map {
        adjustedArr[it]
    }.sorted().asReversed()
    for(dest in destList){
        if(visitedCount[dest]<=depth+1) continue
        visitedCount[dest] = depth+1
        dfs(depth+1,dest)
    }
}
