import java.io.BufferedReader
import java.io.InputStreamReader


data class Edge(val start: Int, val end: Int, val distanceFlag: Int)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val maxParent = IntArray(n + 1) { it }
    val smallParent = IntArray(n + 1) { it }

    val connect = mutableListOf<Edge>()

    repeat(m + 1) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect.add(Edge(temp[0], temp[1], temp[2]))

    }

    var maxSol = 0
    var smallSol = 0
    var edgeNum = 0
    // 오르막길순
    connect.sortWith(compareBy { it.distanceFlag })
    connect.forEach {
        if (findParent(maxParent, it.start) != findParent(maxParent, it.end)) {
            unionParent(maxParent, it.start, it.end)
            edgeNum += 1
            maxSol += (1 - it.distanceFlag)
        }
    }
    // 내리막길 순
    connect.sortWith(compareBy { -it.distanceFlag })
    connect.forEach {
        if (findParent(smallParent, it.start) != findParent(smallParent, it.end)) {
            unionParent(smallParent, it.start, it.end)
            edgeNum += 1
            smallSol += (1 - it.distanceFlag)
        }
    }
    println(maxSol * maxSol - smallSol * smallSol)
}

fun findParent(parent: IntArray, x: Int): Int {
    if (parent[x] != x) {
        parent[x] = findParent(parent, parent[x])
    }
    return parent[x]
}

fun unionParent(parent: IntArray, x: Int, y: Int) {

    val xParent = findParent(parent, x)
    val yParent = findParent(parent, y)

    if (xParent < yParent) {
        parent[yParent] = xParent
    } else {
        parent[xParent] = yParent
    }
}
