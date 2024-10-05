class PuzzleGameChallenge_1005 {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {

        var prev = 0
        val termsArr = Array<Int>(diffs.size) { 0 }
        var termLimit = limit

        for (i in diffs.indices) {
            termsArr[i] = times[i] + prev
            prev = times[i]
            termLimit -= times[i]
        }

        var l = 1
        var r = diffs.max()
        var m = 0

        while (l < r) {
            m = (l + r) / 2
            var mulTimes = diffs.map { if (it < m) 0 else it - m }
            var tmp = 0L
            termsArr.zip(mulTimes).forEach { tmp += it.first * it.second }

            if (tmp <= termLimit) {
                r = m
            } else {
                l = m + 1
            }
        }
        return r
    }
}
