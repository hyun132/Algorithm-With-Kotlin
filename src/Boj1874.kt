
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Stack

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){

    val num = readLine().toInt()

    var nxt = 1

    val stack = Stack<Int>()
    val sb = StringBuilder()
    var input=0
    for(i in 1..num){
        input = readLine().toInt()
        while(nxt<=num&&(stack.isNotEmpty()&& input!=stack.peek() || stack.isEmpty())){
            stack.add(nxt++)
            sb.append('+').append('\n')
        }
        while (stack.isNotEmpty() && input==stack.peek()) {
            stack.pop()
            sb.append('-').append('\n')
        }
    }
    if(stack.isNotEmpty()) {
        println("NO")
        return@with
    }
    print(sb)

}