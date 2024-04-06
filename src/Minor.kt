class Minor {

    private var globalAnswer: Int = Int.MAX_VALUE
    private var pickArr = intArrayOf()
    private var mineralArr = listOf<Int>()
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        pickArr = picks

        mineralArr = minerals.map {
            when (it) {
                "diamond" -> 25
                "iron" -> 5
                else -> 1
            }
        }

        calcDfs(picks[0], picks[1], picks[2], 0, 0)

        return globalAnswer
    }

    private fun calcDfs(d: Int, i: Int, s: Int, sum: Int, depth: Int) {
        if (globalAnswer<depth)return
        if (depth >= mineralArr.size || depth >= pickArr.sum() * 5) {
            if (globalAnswer > sum) globalAnswer = sum
            return
        }

        var tempSum = 0
        if (d > 0) {
            for (i in depth until min(depth + 5, mineralArr.size)) {
                tempSum += 1
            }
            calcDfs(d - 1, i, s, sum + tempSum, depth + 5)
        }
        tempSum = 0
        if (i > 0) {
            for (i in depth until min(depth + 5, mineralArr.size)) {
                tempSum += if (mineralArr[i] >= 5) mineralArr[i] / 5 else 1
            }
            calcDfs(d, i - 1, s, sum + tempSum, depth + 5)
        }
        tempSum = 0
        if (s > 0) {
            for (i in depth until min(depth + 5, mineralArr.size)) {
                tempSum += mineralArr[i]
            }
            calcDfs(d, i, s - 1, sum + tempSum, depth + 5)
        }
        return
    }
}
