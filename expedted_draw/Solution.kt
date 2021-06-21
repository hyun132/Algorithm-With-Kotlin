package expedted_draw

import kotlin.math.log2

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var numA=a
        var numB=b

        //두 숫자가 같은 그룹(연속되는 숫자) 가 되어야 하므로 같은 숫자가 될 때 까지 반복하는 갯수가 라운드의 숫자가 됨.
        for (i in 1..log2(n.toDouble()).toInt()){
            numA=(numA+1)/2
            numB=(numB+1)/2
            if (numA==numB) return i
        }
        return -1
    }
}

fun main() {
    println(Solution().solution(8,4,7))
}
