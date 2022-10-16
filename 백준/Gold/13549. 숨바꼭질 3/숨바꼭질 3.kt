import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

data class Pos(val p: Int, val time: Int)

lateinit var visited: BooleanArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Pos> { p1, p2 -> p1.time - p2.time }
    visited = BooleanArray(100001) { false }
    queue.offer(Pos(n, 0))
    visited[n] = true

    while (queue.isNotEmpty()) {
        val next = queue.poll()
        visited[next.p] = true
        if (next.p == k) {
            println(next.time)
            break
        }
        if(next.p * 2 < 100001 && !visited[next.p * 2]){
            queue.offer(Pos(next.p * 2, next.time))
        }
        if(next.p + 1 < 100001 && !visited[next.p + 1]){
            queue.offer(Pos(next.p + 1, next.time + 1))
        }
        if(next.p - 1 >= 0 && !visited[next.p - 1]){
            queue.offer(Pos(next.p - 1, next.time + 1))
        }
    }
}



