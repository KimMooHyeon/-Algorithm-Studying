import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

const val INF = 200000001

data class MapNode(val index: Int, val dist: Int) : Comparable<MapNode> {
    override fun compareTo(other: MapNode) = dist - other.dist
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, e) = br.readLine().split(" ").map { it.toInt() }
    var dis = IntArray(n) { INF }
    val connect = Array(n) { mutableListOf<MapNode>() }

    repeat(e) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect[temp[0] - 1].add(MapNode(temp[1] - 1, temp[2]))
        connect[temp[1] - 1].add(MapNode(temp[0] - 1, temp[2]))
    }
    val (u, v) = br.readLine().split(" ").map { it.toInt() - 1 }

    fun dijkstra(start: Int) {
        val queue = PriorityQueue<MapNode>()
        dis[start] = 0
        queue.add(MapNode(start, 0))
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
                    queue.add(MapNode(nextIndex, nextDist))
                }
            }
        }
    }
    // 첫번째 정점에서 모든 노드에 대한 최단거리 구하기
    dijkstra(0)
    // 만약 첫번째 정점에서 u번이나 v번경로로 가는 길이 없는 경우 -1 리턴
    if (dis[u] == INF && dis[v] == INF) {
        println(-1)
    } else {
        // 첫번째 정점에서 U번 까지의 최단거리
        val firstToUDistance = dis[u]
        // 첫번째 정점에서 V번 까지의 최단거리
        val firstToVDistance = dis[v]

        // U번 정점에서 모든 노드에 대한 최단거리 구하기
        dis = IntArray(n) { INF }
        dijkstra(u)
        // U번 정점에서 V번 정점까지 최단거리
        val uToVDistance = dis[v]

        // V번 정점에서 모든 노드에 대한 최단거리 구하기
        dis = IntArray(n) { INF }
        dijkstra(v)

        // V번 정점에서 도착지 N번 정점까지 최단거리
        val vToNDistance = dis[n - 1]

        // 첫번째정점 -> U -> V -> N번정점 순으로 돌았을때 거리
        val resultU = firstToUDistance + uToVDistance + vToNDistance


        // V번 정점에서 U번 정점에 대한 최단거리 구하기
        dis = IntArray(n) { INF }
        dijkstra(v)
        val vToUDistance = dis[u]

        // V번 정점에서 도착지 N번 정점까지 최단거리 구하기
        dis = IntArray(n) { INF }
        dijkstra(u)
        val uToNDistance = dis[n - 1]

        // 첫번째정점 -> V -> U -> N번정점 순으로 돌았을때 거리
        val resultV = firstToVDistance + vToUDistance + uToNDistance

        // 만약 둘다 경로가 없었다면 -1 리턴
        if (resultU >= INF && INF <= resultV) {
            println(-1)
        } else {
            println(minOf((resultU), (resultV)))
        }
    }

    br.close()
}

