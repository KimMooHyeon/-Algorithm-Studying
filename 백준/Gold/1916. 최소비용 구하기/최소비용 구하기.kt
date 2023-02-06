import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue


data class Node(val index: Int, val dist: Int) : Comparable<Node> {
    override fun compareTo(other: Node) = dist - other.dist
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    var distinct = Array(n) { Int.MAX_VALUE }
    val connect = Array(n) { mutableListOf<Node>() }

    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1].add(Node(temp[1] - 1, temp[2]))
    }
    val (a,b) = br.readLine().split(" ").map { it.toInt() }
    fun dijkstra(startNum: Int, destination: Int): Int {
        val queue = PriorityQueue<Node>()
        distinct[startNum] = 0
        queue.add(Node(startNum, 0))
        while (queue.isNotEmpty()) {
            val curIndex = queue.peek().index
            val curDist = queue.peek().dist
            queue.poll()
            if (distinct[curIndex] < curDist) continue
            if (curIndex == destination) {
                return distinct[destination]
            }
            for (i in 0 until connect[curIndex].size) {
                val nextIndex = connect[curIndex][i].index
                val nextDist = connect[curIndex][i].dist + curDist
                if (distinct[nextIndex]>nextDist){
                    distinct[nextIndex]=nextDist
                    queue.add(Node(nextIndex,nextDist))
                }
            }
        }
        return -1
    }

    println(dijkstra(a-1,b-1))

    br.close()
    bw.close()
}

