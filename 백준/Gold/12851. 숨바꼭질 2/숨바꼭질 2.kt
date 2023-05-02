import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

data class Pos(val p: Int, val time: Int)

lateinit var visited: BooleanArray
lateinit var dp: IntArray
lateinit var check: IntArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Pos> { p1, p2 -> p1.time - p2.time }
    visited = BooleanArray(100001) { false }
    dp = IntArray(100001) { Int.MAX_VALUE }
    check = IntArray(100001) { 0 }

    queue.offer(Pos(n, 0))
    dp[n] = 0
    visited[n] = true
    var answer = 0
    var answerNum = 0
    while (queue.isNotEmpty()) {
        val next = queue.poll()
        visited[next.p] = true
        if (dp[next.p] == Int.MAX_VALUE) {
            dp[next.p] = next.time
            check[next.p] = 1
        } else if (dp[next.p] < next.time) {
            continue
        } else if (dp[next.p] == next.time) {
            check[next.p] += 1
        } else {
            check[next.p] = 1
        }
        if (next.p == k) {
            answerNum=(next.time)
            answer+=1
        }
        if (next.p * 2 < 100001 && !visited[next.p * 2]) {
            queue.offer(Pos(next.p * 2, next.time + 1))
        }
        if (next.p + 1 < 100001 && !visited[next.p + 1]) {
            queue.offer(Pos(next.p + 1, next.time + 1))
        }
        if (next.p - 1 >= 0 && !visited[next.p - 1]) {
            queue.offer(Pos(next.p - 1, next.time + 1))
        }
    }
    println(answerNum)
    println(answer)
}