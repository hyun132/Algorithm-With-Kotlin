package delivery

import java.util.ArrayDeque

class Solution {

    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {

        val dp = IntArray(N+1) { _ -> Int.MAX_VALUE }
        dp[1]=0

        val graph :HashMap<Int,MutableList<Node>> = HashMap()

        for (edge in road){
            if (!graph.containsKey(edge[0])){
                graph[edge[0]] = mutableListOf(Node(edge[1],edge[2]))
            }else{
                graph[edge[0]]?.add(Node(edge[1],edge[2]))
            }

            if (!graph.containsKey(edge[1])){
                graph[edge[1]] = mutableListOf(Node(edge[0],edge[2]))
            }else{
                graph[edge[1]]?.add(Node(edge[0],edge[2]))
            }
        }

        bfs(Node(1,0),graph,dp,k)
        dp.map { print(it) }
        println()
        return dp.filter { it <=k }.size
    }

    fun bfs(startNode:Node,graph:HashMap<Int,MutableList<Node>>,dp:IntArray,k:Int){
        val q = ArrayDeque<Node>()
        q.add(startNode)

        while (q.size>0){
            val current = q.remove() // 맨 앞 요소 삭제

            graph[current.destination]?.map {
                if (dp[current.destination]+it.distance < dp[it.destination]){ // 다음목적지를 바로가는것보다 현재 목적지를 들르는게 더 빠른경우
                    dp[it.destination]=dp[current.destination]+it.distance // dp값을 갱신해주고
                    if(dp[current.destination]+it.distance <= k){ // 들러서 가는 경우가 k보다 작은값을경우
                        if (!q.contains(it)) q.add(it) //q에 노드를 넣어준다.
                    }
                }
            }
        }
    }
}

data class Node(val destination:Int, val distance:Int)

fun main() {
    println(Solution().solution(5,arrayOf(intArrayOf(1,2,1),intArrayOf(2,3,3),intArrayOf(5,2,2)
            ,intArrayOf(1,4,2),intArrayOf(5,3,1),intArrayOf(5,4,2)),3))
}
