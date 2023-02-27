import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.DecimalFormat
import kotlin.math.roundToLong
import kotlin.math.sqrt

data class Connect(val x: Int, val y: Int, val distance: Int)

fun main() {
    var sol = 0
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }
    val connectList = mutableListOf<Connect>()
    repeat(m) {
        val nList = br.readLine().split(" ").map { it.toInt() }
        connectList.add(Connect(nList[0], nList[1], nList[2]))
    }
    connectList.sortWith(compareBy { it.distance })
    connectList.forEach {
        if (findParent(parent, it.x) != findParent(parent, it.y)) {
            unionParent(parent, it.x, it.y)
            sol += it.distance
        }
    }
    println(sol)
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