import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.sqrt

data class SpaceGod(val x: Int, val y: Int, val index: Int)
data class Edge(val i: Int, val j: Int, val distance: Double)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var sol = 0.0
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }
    val connectList = mutableListOf<Edge>()
    val godList = Array(n + 1) { SpaceGod(0, 0, 0) }

    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        godList[it + 1] = (SpaceGod(x, y, it + 1))
    }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        if (findParent(parent, a) != findParent(parent, b)) {
            unionParent(parent, a, b)
        }
    }
    for (i in 1..n) {
        for (j in i + 1..n) {
            if (findParent(parent, i) != findParent(parent, j)) {
                connectList.add(Edge(i, j, getDistance(godList[i], godList[j])))
            }
        }
    }

    connectList.sortWith(compareBy { it.distance })
    connectList.forEach {
        if (findParent(parent, it.i) != findParent(parent, it.j)) {
            unionParent(parent, it.i, it.j)
            sol += it.distance
        }
    }
    System.out.printf("%.2f\n", sol)

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

fun getDistance(a: SpaceGod, b: SpaceGod): Double {
    val aMath: Long = (a.x - b.x).toLong()
    val bMath: Long = (a.y - b.y).toLong()
    return sqrt((abs(aMath*aMath) + abs(bMath*bMath)).toDouble())
}
