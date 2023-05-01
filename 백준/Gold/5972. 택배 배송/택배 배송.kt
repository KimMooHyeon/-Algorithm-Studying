import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

data class Node(val number: Int, val dist: Int) : Comparable<Node> {
    override fun compareTo(other: Node) = dist - other.dist
}


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val connect = Array(n + 1) { mutableListOf<Node>() }
    val distinct = IntArray(n + 1) { Int.MAX_VALUE }
    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0]].add(Node(temp[1], temp[2]))
        connect[temp[1]].add(Node(temp[0], temp[2]))
    }

    fun dijkstra(start: Int, destination: Int): Int {
        val queue = PriorityQueue<Node>()
        distinct[start] = 0
        queue.add(Node(start, 0))
        while (queue.isNotEmpty()) {
           // println(queue.peek())
            val curIndex = queue.peek().number
            val curDist = queue.peek().dist
            queue.poll()
            if (distinct[curIndex] < curDist) continue

            if (curIndex == destination) {
                return distinct[destination]
            }
            for (i in 0..connect[curIndex].lastIndex) {
                val nextIndex = connect[curIndex][i].number
                val nextCost = connect[curIndex][i].dist + curDist
                if (distinct[nextIndex] > nextCost) {
                    distinct[nextIndex] = nextCost
                    queue.add(Node(nextIndex, nextCost))
                }
            }
        }
        return 1
    }
    println(dijkstra(1, n))
}