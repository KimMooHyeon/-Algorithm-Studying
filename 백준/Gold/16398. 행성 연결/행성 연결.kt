import java.io.BufferedReader
import java.io.InputStreamReader


data class Edge(val start: Int, val end: Int, val distance: Int)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val map = mutableListOf<MutableList<Int>>()
    val parent = IntArray(n) { it }
    val connect = mutableListOf<Edge>()
    repeat(n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        map.add(temp.toMutableList())
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i != j) {
                connect.add(Edge(i, j, map[i][j]))
            }
        }
    }
    var sol: Long = 0
    connect.sortWith(compareBy { it.distance })
    connect.forEach {
        if (findParent(parent, it.start) != findParent(parent, it.end)) {
            unionParent(parent, it.start, it.end)
            sol += it.distance
        }
    }
    println(sol)
}

fun findParent(parent: IntArray, x: Int): Int {
    if (x == -1) {
        return -1
    }
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
