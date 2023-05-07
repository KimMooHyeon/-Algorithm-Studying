import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue

data class Road(val destination: Int, var distinct: Int) : Comparable<Road> {
    override fun compareTo(other: Road) = other.distinct - distinct
}

data class Connect(val index: Int, var cost: Int)

fun dijkstra(startIndex: Int, map: IntArray, connect: Array<MutableList<Road>>) {
    val queue = LinkedList<Connect>()
    queue.add(Connect(startIndex, 0))
    while (queue.isNotEmpty()) {
        val curQueue = queue.poll()

        if (curQueue.cost > map[curQueue.index]) {
            continue
        } else {
            map[curQueue.index] = curQueue.cost
        }
        for (i in 0..connect[curQueue.index].lastIndex) {
            val temp = connect[curQueue.index][i]
            queue.add(Connect(temp.destination, temp.distinct + curQueue.cost))
        }

    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 지역의 개수 n , 수색범위 m, 길의 개수 r
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val map = IntArray(n + 1)
    var distinctMap = IntArray(n + 1) { Int.MAX_VALUE }
    val score = br.readLine().split(" ").map { it.toInt() }
    val connect = Array(n + 1) { mutableListOf<Road>() }
    score.forEachIndexed { i, v ->
        map[i + 1] = v
    }
    repeat(r) {
        val road = br.readLine().split(" ").map { it.toInt() }
        connect[road[0]].add(Road(road[1], road[2]))
        connect[road[1]].add(Road(road[0], road[2]))
    }

    var answer = 0
    var sum = 0
    for (i in 1..n) {
        sum = 0
        // 수색범위 m
        distinctMap = IntArray(n + 1) { Int.MAX_VALUE }
        distinctMap[i] = 0
        dijkstra(i, distinctMap, connect)
        for (i in 1..n) {
            if (distinctMap[i] <= m) {
                sum+=map[i]
            }
        }
        answer= maxOf(answer,sum)
    }
    println(answer)
    br.close()
}