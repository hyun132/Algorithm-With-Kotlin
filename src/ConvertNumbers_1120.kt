import java.util.PriorityQueue
import kotlin.math.min
class Solution {
    var answer: Int = Int.MAX_VALUE
    fun solution(x: Int, y: Int, n: Int): Int {
        answer = Int.MAX_VALUE

        if (x == y) return 0

        val visited = setOf<Pair<Int,Int>>()
        val q = PriorityQueue<Pair<Int,Int>>{ a,b ->
            a.second-b.second
        }
        q.add(Pair(y,0))

        while (q.isNotEmpty()){
            val (num,depth) = q.poll()

            if (depth >= answer) continue
            if (num <= x) {
                if (num == x) answer = min(answer, depth)
                continue
            }

            if (num % 3 == 0 && num >= x * 3) {
                 q.add(Pair(num / 3,depth + 1))
            }
            if (num % 2 == 0 && num >= x * 2) {
                q.add(Pair(num / 2, depth + 1))
            }
            if (num >= x + n) {
                 q.add(Pair(num - n, depth + 1))
            }
        }
        if (answer == Int.MAX_VALUE) answer = -1
        return answer
    }

    fun solution2(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0

        val visited = mutableSetOf<Int>()
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(y, 0))

        while (queue.isNotEmpty()) {
            val (num, depth) = queue.poll()

            if (num in visited) continue
            visited.add(num)

            if (num == x) return depth

            // 숫자를 나누거나 빼는 연산 수행
            if (num % 3 == 0 && num / 3 >= x) {
                queue.add(Pair(num / 3, depth + 1))
            }
            if (num % 2 == 0 && num / 2 >= x) {
                queue.add(Pair(num / 2, depth + 1))
            }
            if (num - n >= x) {
                queue.add(Pair(num - n, depth + 1))
            }
        }

        return -1 // 목표 숫자에 도달할 수 없는 경우
    }
}
