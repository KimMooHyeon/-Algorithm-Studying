import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.DecimalFormat
import kotlin.math.roundToLong
import kotlin.math.sqrt

data class Star(val x: Float, val y: Float)
data class Connect(val x: Int, val y: Int, val distance: Float)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val starList = mutableListOf<Star>()
    // i에서 j까지의 거리
    val connect = Array(n + 1) { FloatArray(n + 1) { Float.MAX_VALUE } }
    val parent = IntArray(n + 1) { it }
    val connectList = mutableListOf<Connect>()
    starList.add(Star(0.0F, 0.0F))
    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toFloat() }
        starList.add(Star(x, y))
    }
    for (i in 1..n) {
        for (j in 1..n) {
            if (i == j) {
                connect[i][j] = 0.0F
            } else {
                connect[i][j] = distance(starList[i], starList[j])
                connectList.add(Connect(i, j, connect[i][j]))
            }
        }
    }
    var sol = 0.0F
    connectList.sortWith(compareBy { it.distance })
    connectList.forEach {
        if (findParent(parent, it.x) != findParent(parent, it.y)) {
            sol += it.distance
            unionParent(parent, it.x, it.y)
        }
    }
    val df = DecimalFormat("#.##")
    println(df.format(sol))
}

fun distance(a: Star, b: Star): Float {
    return sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y))
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