import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

data class Node(val index: Space, val cost: Int) : Comparable<Node> {
    override fun compareTo(other: Node) = cost - other.cost
}

data class Space(val x: Int, val y: Int)

val hash = HashMap<Space, Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var case = 0
    while (true) {
        case += 1
        val n = br.readLine().toInt()
        if (n == 0) {
            return
        }
        val map = Array(n) { IntArray(n) { 0 } }
        repeat(n) {
            val nList = br.readLine().split(" ").map { it.toInt() }
            for (i in 0 until n) {
                map[it][i] = nList[i]
                hash[Space(it, i)] = Int.MAX_VALUE
            }
        }
        /*       map.forEach {
                   //       println(it.contentToString())
               }*/
        println("Problem ${case}: ${dijkstra(destination = Space(n - 1, n - 1), n = n, map = map)}")

    }
}

val yOffset = arrayOf(0, 1, -1,0)
val xOffset = arrayOf(1, 0, 0,-1)

fun dijkstra(startIndex: Space = Space(0, 0), destination: Space, map: Array<IntArray>, n: Int): Int? {
    val queue = PriorityQueue<Node>()
    queue.add(Node(startIndex, map[startIndex.y][startIndex.x]))
    while (queue.isNotEmpty()) {
        val curIndex = queue.peek().index
        val curCost = queue.peek().cost
        queue.poll()

        if (hash[curIndex]!! < curCost) continue
        // destination에 도착하면 값 return
        if (curIndex == destination) {
            return hash[destination]
        }

        for (i in 0..3) {
            val nextX = curIndex.x + xOffset[i]
            val nextY = curIndex.y + yOffset[i]
            if (nextY in 0 until n && nextX in 0 until n) {
                val nextSpace = Space(nextX, nextY)
                if (hash[nextSpace]!! > curCost + map[nextY][nextX]) {
                    hash[nextSpace] = curCost + map[nextY][nextX]
                    queue.add(Node(nextSpace, curCost + map[nextY][nextX]))
                }
            }
        }

    }
    return -1
}