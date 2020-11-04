fun main() {
    val n =2
    val result :Int=fib(n)
    print(result)
}

fun fib(n: Int): Int {
    var answer = mutableListOf(0,1)

    for (i in 2..n){
        answer.add((answer[i-2]+answer[i-1])%1234567)
    }

    return answer[n]
}
