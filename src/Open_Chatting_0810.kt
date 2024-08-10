class Open_Chatting_0810 {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayListOf<String>()
        val userMap = hashMapOf<String, String>()
        val logMap = mutableListOf<Pair<String, String>>()

        for (one in record) {
            val origin = one.split(" ")
            if (origin.size > 2) userMap[origin[1]] = origin[2]
            when (origin[0]) {
                "Enter" -> {
                    logMap.add(origin[1] to "들어왔습니다.")
                }
                "Leave" -> {
                    logMap.add(origin[1] to "나갔습니다.")
                }
            }
        }

        logMap.forEach {
            answer.add(userMap[it.first] + "님이 " + it.second)
        }
        return answer.toTypedArray()
    }
}
