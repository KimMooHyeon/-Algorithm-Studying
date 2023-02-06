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

    val (n, m, x) = br.readLine().split(" ").map { it.toInt() }
    var distinct = Array(n) { Int.MAX_VALUE }
    val connect = Array(n) { mutableListOf<Node>() }

    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1].add(Node(temp[1] - 1, temp[2]))
    }
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

    var maxNum=0
    repeat(n){
        distinct = Array(n) { Int.MAX_VALUE }
        val temp1 = (dijkstra(it,x-1))
        distinct = Array(n) { Int.MAX_VALUE }
        val temp2 = (dijkstra(x-1,it))
        if (maxNum<temp1+temp2){
            maxNum=temp1+temp2
        }
    }
    println(maxNum)
    br.close()
    bw.close()
}

