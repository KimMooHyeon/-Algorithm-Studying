import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import kotlin.math.max

lateinit var visited: Array<IntArray>
var graph = mutableListOf<List<Char>>()
var n: Int = 0
var m: Int = 0

var res = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (_n, _m) = br.readLine().split(" ").map { it.toInt() }
    n = _n
    m = _m
    visited = Array(n) { IntArray(m) { 0 } }
    for (i in 1..n) {
        graph.add(br.readLine().toList())
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            bfs(i, j)
        }
    }
    println(res)
}

fun bfs(x: Int, y: Int) {
    if (visited[x][y] == 1) {
        return
    } else {
        visited[x][y] = 1
        res += 1
    }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(x, y))
    while (queue.isNotEmpty()) {
        var (a, b) = queue.poll()
        if (graph[a][b] == '-') {
            b += 1
        } else {
            a += 1
        }
        if (a in 0 until n
            && b in 0 until m
            && visited[a][b] == 0
            && graph[a][b] == graph[x][y]
        ) {
            visited[a][b] = 1
            queue.add(Pair(a, b))
        }
    }
}


