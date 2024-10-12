class TicTacToAlone {

    var board: Array<String> = arrayOf()

    fun solution(b: Array<String>): Int {
        board = b
        var answer = 0

        val x = board.sumOf { it.count { it == 'X' } }
        val o = board.sumOf { it.count { it == 'O' } }
        if (checkIsOver('O') && !checkIsOver('X') && o - x == 1)
            answer = 1
        else if (checkIsOver('X') && !checkIsOver('O') && x == o)
            answer = 1
        else if (o - x in 0..1 && !checkIsOver('O') && !checkIsOver('X'))
            answer = 1

        return answer
    }

    fun checkIsOver(who: Char): Boolean {
        return board.any { it.all { it == who } } ||
                (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] == who) ||
                (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] == who) ||
                (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] == who) ||
                (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == who) ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == who)
    }
}
