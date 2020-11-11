fun solution(s: String): IntArray {

    var answer: IntArray = intArrayOf(0,0)
    var x = s
    while (x != "1") {
        var len = x.filterNot { it == '0' }.length
        answer[1] += x.length-len
        x=len.toString(2)
        answer[0]+=1
    }
    return answer
}

fun main() {
    var s = "110010101001"
    solution(s)
}
