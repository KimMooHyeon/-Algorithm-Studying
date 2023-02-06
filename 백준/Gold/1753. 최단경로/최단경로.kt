import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

data class Node(val index: Int, val dist: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = dist - other.dist
}


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val startIndex = br.readLine().toInt()
    val dis = IntArray(v) { Int.MAX_VALUE }
    val connect = Array(v) { mutableListOf<Node>() }

    repeat(e) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1].add(Node(temp[1] - 1, temp[2]))
    }
    fun dijkstra(start: Int) {
        val queue = PriorityQueue<Node>()
        dis[start] = 0
        queue.add(Node(start, 0))
        while (queue.isNotEmpty()) {
            val (curIndex, curDist) = queue.poll() // 0,0
            if (dis[curIndex] < curDist) {
                continue
            }
            for (i in 0 until connect[curIndex].size) {
                val nextIndex = connect[curIndex][i].index
                val nextDist = connect[curIndex][i].dist + curDist
                if (nextDist < dis[nextIndex]) {
                    dis[nextIndex] = nextDist
                    queue.add(Node(nextIndex, nextDist))
                }
            }
        }
    }
    dijkstra(startIndex-1)

    dis.forEach {
        if (it == Int.MAX_VALUE) {
            println("INF")
        } else {
            println(it)
        }
    }

    br.close()
    bw.close()
}