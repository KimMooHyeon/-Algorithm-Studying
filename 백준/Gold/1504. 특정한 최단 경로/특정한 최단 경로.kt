import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs
const val INF = 200000001
data class Node(val index: Int, val dist: Int) : Comparable<Node> {
    override fun compareTo(other: Node) = dist - other.dist
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, e) = br.readLine().split(" ").map { it.toInt() }
    var dis = IntArray(n) { INF }
    val connect = Array(n) { mutableListOf<Node>() }

    repeat(e) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1].add(Node(temp[1] - 1, temp[2]))
        connect[temp[1] - 1].add(Node(temp[0] - 1, temp[2]))
    }
    val (u, v) = br.readLine().split(" ").map { it.toInt() - 1 }

    fun dijkstra(start: Int) {
        val queue = PriorityQueue<Node>()
        dis[start] = 0
        queue.add(Node(start, 0))
        while (queue.isNotEmpty()) {
            val curIndex = queue.peek().index
            val curDist = queue.peek().dist
            queue.poll()

            if (dis[curIndex] < curDist) continue

            for (i in 0 until connect[curIndex].size) {
                val nextIndex = connect[curIndex][i].index
                val nextDist = connect[curIndex][i].dist + curDist
                if (dis[nextIndex] > nextDist) {
                    dis[nextIndex] = nextDist
                    queue.add(Node(nextIndex, nextDist))
                }
            }
        }
    }
    dijkstra(0)

    if (dis[u] == INF && dis[v] == INF) {
        println(-1)
    } else {
        val tempU = dis[u]
        val tempV = dis[v]

        dis = IntArray(n) { INF }
        dijkstra(u)
        val tempU2 = dis[v]
        dis = IntArray(n) { INF }
        dijkstra(v)
        val tempU3 = dis[n - 1]
        val resultU = (tempU + tempU2 + tempU3)

        dis = IntArray(n) { INF }
        dijkstra(v)
        val tempV2 = dis[u]
        dis = IntArray(n) { INF }
        dijkstra(u)
        val tempV3 = dis[n - 1]
        val resultV = (tempV + tempV2 + tempV3)

        if (resultU >= INF && INF <= resultV) {
            println(-1)
        } else {
            println(minOf((resultU),(resultV)))
        }

    }

    br.close()
    bw.close()
}

