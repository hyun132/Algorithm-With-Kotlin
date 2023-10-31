package leetcode.tryeasyproblem

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.min


var parents = arrayOf<Int>()
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    val ve = readLine().split(' ').map { it.toInt() }

    parents = Array<Int>(ve[0]+1){it}
    var answer = 0

    val pq = PriorityQueue<Edge> { o1, o2 -> o1.weight - o2.weight }
    for(i in 1..ve[1]){
        val edge = readLine().split(' ').map { it.toInt() }
        pq.add(Edge(edge[0],edge[1],edge[2]))
    }

    var cnt = ve[0]-1
    var start = min( pq.peek().from,pq.peek().to)
    while (cnt>0){

        val v = pq.poll()
        if(findParent(v.from) == findParent(v.to)) continue
        union(v.from,v.to)
        answer+=v.weight
        cnt-=1
    }
    
    println(answer)
}

fun union(from:Int, to:Int) {
    val a = findParent(from)
    val b = findParent(to)
    if(a>b) parents[a] = b
    else parents[b]=a
}

fun findParent(child:Int):Int{
    if(parents[child] == child) return child
    return findParent(parents[child])
}

data class Edge(
        val from:Int,
        val to:Int,
        val weight:Int
)
