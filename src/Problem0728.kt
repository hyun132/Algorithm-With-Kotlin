class Solution {
    fun solution(card: IntArray): Int {
        var maxMul = 0
        val visited = Array(card.size+1){false}
        var circles = mutableListOf<Int>()
        var cards = intArrayOf(0)+card
        for(i in 1 until cards.size){
            if(visited[i])continue
            var nxt = cards[i]
            var cnt = 0
            while(!visited[nxt]){
                visited[nxt] = true
                nxt = cards[nxt]
                cnt++
            }
            circles.add(cnt)
        }
        if(circles.size==1) return 0
        for(i in 0 until circles.size-1){
            for(j in i+1 until circles.size){
                maxMul = Math.max(maxMul,circles[i]*circles[j])
            }
        }
        
        return maxMul
    }
}
