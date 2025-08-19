import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val str = readLine()?.trim()?:""
    val stack = Stack<Char>()
    val valueArr = IntArray(str.length)
    for (idx in 0 until str.length) {
        val c = str[idx]
        if(c == '(' || c == '[') stack.add(c)
        else{
            if(stack.isEmpty()) return println("0")
            if(c == ')' && stack.peek() == '(') {
                stack.pop()
                valueArr[stack.size] = valueArr[stack.size] + (if(valueArr[stack.size+1]==0) 1 else valueArr[stack.size+1])*2
                valueArr[stack.size+1] = 0
            } else if(c == ']' && stack.peek() == '[') {
                stack.pop()
                valueArr[stack.size] = valueArr[stack.size] + (if(valueArr[stack.size+1]==0) 1 else valueArr[stack.size+1])*3
                valueArr[stack.size+1] = 0
            }
            else return println("0")
        }
    }
    println(valueArr[0])
}
