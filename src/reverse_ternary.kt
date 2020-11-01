fun main() {
    val n=125
    solution(n)
    solution2(n)
}
fun solution(n: Int): Int {
    var answer= ""
    var temp=n
    while (temp>=3){
        answer=(temp%3).toString()+answer
        temp=(temp/3)
    }
    answer=(temp).toString()+answer

    var result=0
    var toMul=1
    for(num in answer){
        result+=Integer.parseInt(num.toString())*toMul
        toMul*=3
    }
    return result

}

fun solution2(n: Int): Int {
    return n.toString(3).reversed().toInt(3)
}
