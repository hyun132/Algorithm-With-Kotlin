import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var answer = 0
    val case = readLine().trim().toInt()
    for (i in 0 until case){
        var input = readLine().trim()

        val chars = mutableSetOf<Char>()
        chars.add(input.first())
        for (idx in 0 until input.length-1){
            if(input[idx]!=input[idx+1]){
                if(chars.add(input[idx+1])==false) {
                    answer--
                    break
                }
            }
        }
        answer++
    }
    println(answer)
}
