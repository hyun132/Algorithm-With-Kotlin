package leetcode.tryeasyproblem

class Babbling {

    val visited = arrayOf(false,false,false,false) // "aya", "ye", "woo", "ma"
    val word = arrayOf("aya", "ye", "woo", "ma")
    val cases = mutableSetOf<String>()
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0

        findAllCases("")

        babbling.forEach { if(cases.contains(it)) answer+=1 }
        return answer
    }

    fun findAllCases(string: String){

        for(w in word.indices){
            if(visited[w]) continue
            visited[w] = true
            cases.add(string+word[w])
            findAllCases(string+word[w])
            visited[w] = false
        }
    }
}

fun main() {
    val sol = Babbling()
    println(sol.solution(arrayOf("aya", "yee", "u", "maa", "wyeoo")))
    println(sol.solution(arrayOf("ayaye", "uuuma", "ye", "yemawoo", "ayaa")))
}