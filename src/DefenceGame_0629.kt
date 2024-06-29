import java.util.*

class DefenceGame_0629 {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var turn = 0
        var remain = n
        var skill = k
        var lastList = PriorityQueue<Int>()
        while (remain >= 0 && skill >= 0 && turn < enemy.size) {
            remain -= enemy[turn]
            lastList.add(-enemy[turn])
            while (remain < 0 && skill > 0 && lastList.isNotEmpty()) {
                remain -= lastList.poll()
                skill--
            }
            if (remain >= 0) turn++
        }

        return turn
    }
}
