
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


data class Point(val y: Int, val x: Int)

fun bfs(map: Array<IntArray>, N: Int, M: Int, H: Int, W: Int): Int {
    if (H == 1 && W == 1) {
        return 1
    }
    var answer = 0
    val queue = LinkedList<Point>()
    val xOffset = listOf(0, 0, N + 1, -(N + 1))
    val yOffset = listOf(M + 1, -(M + 1), 0, 0)
    queue.add(Point(0, 0))
    while (queue.isNotEmpty()) {
        val curPoint = queue.poll()
        for (i in 0..3) {
            val nextX = xOffset[i] + curPoint.x
            val nextY = yOffset[i] + curPoint.y
            if (nextX in 0 until W && nextY in 0 until H) {
                if (map[nextY][nextX] == 0) {
                    answer += 1
                    map[nextY][nextX] = 1
                    queue.add(Point(nextY, nextX))
                }
            }
        }
    }
    return answer
}


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    // 테이블이 행마다 W개씩 H행에 걸쳐 있을 때
    // 모든 참가자는 세로로 N칸 또는 가로로 M칸 이상 비우고 앉아야 한다.
    // 다른 모든 참가자와 세로줄 번호의 차가 N보다 크거나
    // 가로줄 번호의 차가 M보다 큰 곳에만 앉을 수 있다.
    val (H, W, N, M) = br.readLine().split(" ").map { it.toInt() }
    val height = (H - 1) / (N + 1) + 1
    val width = (W - 1) / (M + 1) + 1
    println(height*width)
    br.close()
    bw.close()
}
