import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(val index: Int, val dist: Int) : Comparable<Node> {
    override fun compareTo(other: Node) = dist - other.dist
}

data class MapInfo(var dist: Int, var mapList: MutableList<Int>)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val mapList = Array(n) { MapInfo(Int.MAX_VALUE, mutableListOf<Int>()) }
    val connect = Array(n) { mutableListOf<Node>() }


    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1].add(Node(temp[1] - 1, temp[2]))
    }
    val (a, b) = br.readLine().split(" ").map { it.toInt() }

    fun dijkstra(startNum: Int, destination: Int) {
        val queue = PriorityQueue<Node>()
        mapList[startNum].dist = 0
        mapList[startNum].mapList.add(startNum)
        queue.add(Node(startNum, 0))
        while (queue.isNotEmpty()) {
            val curIndex = queue.peek().index
            val curDist = queue.peek().dist
            queue.poll()

            // 기존 거리보다 더 거리가 큰 경로는 무시
            if (mapList[curIndex].dist < curDist) continue

            // destination에 도착하면 값 return
            if (curIndex == destination) {
                return
            }

            // 현재 경로에서 갈 수 있는 Node 탐색
            for (i in 0 until connect[curIndex].size) {
                val nextIndex = connect[curIndex][i].index
                val nextDist = connect[curIndex][i].dist + curDist

                // 다음 Node의 값보다 현재까지 온 경로의 값이 더 작으면 업데이트
                if (mapList[nextIndex].dist > nextDist) {
                    mapList[nextIndex].dist = nextDist
                    mapList[nextIndex].mapList = mapList[curIndex].mapList.map { it } as MutableList<Int>
                    mapList[nextIndex].mapList.add(nextIndex)
                    queue.add(Node(nextIndex, nextDist))
                }
            }
        }
    }
    dijkstra(a - 1, b - 1)

    println(mapList[b - 1].dist)
    for (i in 0 until  mapList[b - 1].mapList.size){
        mapList[b - 1].mapList[i]+=1
    }
    println(mapList[b - 1].mapList.size)
    println(mapList[b - 1].mapList.joinToString(" "))
    br.close()
}

