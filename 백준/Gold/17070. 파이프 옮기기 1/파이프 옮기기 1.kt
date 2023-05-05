import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

data class Pipe(val y: Int, val x: Int, var space: String)

var answer = 0
fun bfs(n: Int, map: Array<MutableList<Int>>) {
    val queue = LinkedList<Pipe>()
    queue.add(Pipe(0, 1, "right"))
    while (queue.isNotEmpty()) {
        val curPipe = queue.poll()
        if (curPipe.y == n - 1 && curPipe.x == n - 1) {
            answer += 1
            continue
        }
        when (curPipe.space) {
            "right" -> {
                //오른쪽, 대각선 아래 가능
                val nextX = curPipe.x + 1
                val nextY = curPipe.y + 1
                if (nextX < n) {
                    if (map[curPipe.y][nextX] == 0) {
                        queue.add(Pipe(curPipe.y, nextX, "right"))
                    }
                }
                if (nextX < n && nextY < n) {
                    if (map[nextY][nextX] == 0
                        && map[nextY - 1][nextX] == 0
                        && map[nextY][nextX - 1] == 0
                    ) {
                        queue.add(Pipe(nextY, nextX, "rd"))
                    }
                }

            }
            "rd" -> {
                //오른쪽, 대각선아래, 아래 가능
                val nextX = curPipe.x + 1
                val nextY = curPipe.y + 1
                if (nextX < n) {
                    if (map[curPipe.y][nextX] == 0) {
                        queue.add(Pipe(curPipe.y, nextX, "right"))
                    }
                }
                if (nextX < n && nextY < n) {
                    if (map[nextY][nextX] == 0
                        && map[nextY - 1][nextX] == 0
                        && map[nextY][nextX - 1] == 0
                    ) {
                        queue.add(Pipe(nextY, nextX, "rd"))
                    }
                }
                if (nextY < n) {
                    if (map[nextY][curPipe.x] == 0) {
                        queue.add(Pipe(nextY, curPipe.x, "down"))
                    }
                }
            }
            "down" -> {
                //아래방향
                //아래, 대각선 아래 가능
                val nextX = curPipe.x + 1
                val nextY = curPipe.y + 1
                if (nextX < n && nextY < n) {
                    if (map[nextY][nextX] == 0
                        && map[nextY - 1][nextX] == 0
                        && map[nextY][nextX - 1] == 0
                    ) {
                        queue.add(Pipe(nextY, nextX, "rd"))
                    }
                }
                if (nextY < n) {
                    if (map[nextY][curPipe.x] == 0) {
                        queue.add(Pipe(nextY, curPipe.x, "down"))
                    }
                }
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 세로 N, 가로 M
    val n = br.readLine().toInt()
    val map = Array(n) { mutableListOf<Int>() }
    repeat(n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        map[it] = temp.toMutableList()
    }
    if (map[n - 1][n - 1] == 1) {
        println(0)
    } else {
        if (map[n - 1][n - 2] ==1 && map[n - 2][n - 1] ==1){
            println(0)
        }else{
            bfs(n, map)
            println(answer)
        }
    }

    br.close()
}
