import java.io.BufferedReader
import java.io.InputStreamReader

data class Space(val x: Int, val y: Int)

val hash = HashMap<String, Boolean>()
var maxNum = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(r) { Array(c) { " " } }
    repeat(r) { index ->
        val temp = br.readLine().toList().map { it.toString() }
        for (i in temp.indices) {
            board[index][i] = temp[i]
            hash[temp[i]] = true
        }
    }
    hash[board[0][0]] = false
    dfs(Space(0, 0), 1, board, r, c)
    println(maxNum)
}

val xOffset = arrayOf(0, 0, 1, -1)
val yOffset = arrayOf(1, -1, 0, 0)

fun dfs(curSpace: Space, num: Int, board: Array<Array<String>>, r: Int, c: Int) {
    if (maxNum < num) {
        maxNum = num
    }
    val curX = curSpace.x
    val curY = curSpace.y
    for (i in 0..3) {
        val nextX = curX + xOffset[i]
        val nextY = curY + yOffset[i]
        if (nextX in 0 until c && nextY in 0 until r) {
            if (hash[board[nextY][nextX]]!!) {
                hash[board[nextY][nextX]] = false
                dfs(Space(nextX, nextY), num + 1, board, r, c)
                hash[board[nextY][nextX]] = true
            }
        }
    }
}