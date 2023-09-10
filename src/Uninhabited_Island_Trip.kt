package leetcode.tryeasyproblem

import java.util.Queue
import javax.swing.text.Position

class Uninhabited_Island_Trip {
    lateinit var map :Array<IntArray>
    val direction = arrayOf(Point(1,0), Point(-1,0), Point(0,1), Point(0,-1))
    var answer = mutableListOf<Int>()
    fun solution(maps: Array<String>): IntArray {


        map = Array(maps.size){IntArray(maps[0].length){-1} }

        for(r in 0 until maps.size){
            for(c in 0 until maps[r].length){
                val ch = maps[r][c]
                if(ch.isDigit()) map[r][c] = Character.getNumericValue(ch)
            }
        }

        for (r in map){
            println(r.toString())
        }

        for(y in 0 until map.size){
            for(x in 0 until map[y].size){
               if(map[y][x]<=0) continue
                dfs(y,x)
            }
        }
        answer.sort()
        return if(answer.isEmpty()) intArrayOf(-1) else answer.toIntArray()
    }

    fun dfs(sy:Int,sx:Int){
        var sum = map[sy][sx]
        val q :ArrayDeque<Point> = ArrayDeque()
        q.add(Point(sy,sx))
        map[sy][sx]=0
        var ny = 0
        var nx = 0
        var start:Point
        while (q.isNotEmpty()){
            start = q.removeFirst()

            for (d in direction){
                ny = d.y + start.y
                nx = d.x + start.x

                if(isOutOfBound(ny,nx) || map[ny][nx]<=0) continue
                q.add(Point(ny,nx))
                sum +=  map[ny][nx]
                map[ny][nx] = 0
            }
        }

        answer.add(sum)
    }

    fun isOutOfBound(y:Int,x:Int):Boolean{
        return if(x<0 || y<0 || x>=map[0].size || y>= map.size) true else false
    }

    data class Point(val y:Int,val x:Int)

}

fun main() {
    val solution = Uninhabited_Island_Trip()
    solution.solution(arrayOf("X591X", "X1X5X", "X231X", "1XXX1")).forEach {
        println(it)
    }

}
