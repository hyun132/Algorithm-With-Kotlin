class LeetCode2370 {
    var str = ""
    var dp = Array<Int>(26) { 0 }
    fun longestIdealString(s: String, k: Int): Int {
        str = s
        for (ch in str) {
            val curIdx = ch - 'a'
            for (i in max(0, curIdx - k)..min(25, curIdx + k)){
                dp[curIdx] = max(dp[curIdx],dp[i])
            }
            dp[curIdx]+=1
        }

        return dp.max()
    }
}
