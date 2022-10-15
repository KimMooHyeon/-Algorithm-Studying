import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

lateinit var graph: Array<MutableList<Int>>
lateinit var visited: Array<Int>
var a = 0
var b = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (_a, _b) = br.readLine().split(" ").map { it.toInt() }
    a = _a
    b = _b
    val m = br.readLine().toInt()
    graph = Array(n + 1) { mutableListOf<Int>() }
    visited = Array(n + 1) { 0 }
    for (i in 0 until m) {
        val (parent, child) = br.readLine().split(" ").map { it.toInt() }
        graph[parent].add(child)
        graph[child].add(parent)
    }
  println(bfs(a,b))
}

fun bfs(x: Int, y: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(x, 0))
    visited[x] = 1
    while (queue.isNotEmpty()) {
        val (node, cnt) = queue.poll()
        for (i in graph[node]) {
            if (visited[i] == 0) {
                visited[i] = 1
                queue.add(Pair(i, cnt + 1))
                if (i == y) return cnt + 1
            }
        }
    }
    return -1
}