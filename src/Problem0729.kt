class Solution {
    
    val dy = arrayOf(1,0,0,-1)
    val dx = arrayOf(0,1,-1,0)
    
    val difMap = mapOf<String,Int>("0S" to 0,"1S" to 1,"2S" to 2, "3S" to 3,
                      "0R" to 2, "1R" to 0, "2R" to 3, "3R" to 1,
                      "0L" to 1, "1L" to 3, "2L" to 0, "3L" to 2)
    
    var n = 0
    var m = 0
    var visited = arrayOf<Array<Array<Boolean>>>()
    var answer = arrayListOf<Int>()
        
    fun solution(grid: Array<String>): IntArray {
        n = grid.size
        m = grid[0].length
        
       visited = Array(4) { Array(n) { Array(m) { false } } }
      
        
        for(i in 0 until n){
            for (j in 0 until m){
                for(k in 0 until 4){
                    if(visited[k][i][j]) continue;
                    bfs(i,j,k,grid)
                }
            }
        }
        
        return answer.sorted().toIntArray()
    }
    
    fun bfs(y:Int,x:Int,dir:Int,grid: Array<String>){
        
        val q = ArrayDeque<Triple<Int,Int,Int>>()
        q.add(Triple(y,x,dir))
        var count = 0
        while(q.isNotEmpty()){
            count++
            val cur = q.removeFirst()
            visited[cur.third][cur.first][cur.second] = true
            val d :Int= difMap["${cur.third}${grid[cur.first][cur.second]}"] ?: return
            
            var ny = (cur.first + dy[d] + n) % n
            var nx = (cur.second + dx[d] + m) % m
            
            if(visited[d][ny][nx]) continue
            q.add(Triple(ny,nx,d))
        }
        answer.add(count)
    }
}
