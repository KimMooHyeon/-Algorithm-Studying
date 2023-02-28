import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        var sol = 0
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val parent = IntArray(n + 1) { it }
        val connectList = mutableListOf<IntArray>()
        repeat(m) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            connectList.add(intArrayOf(a, b))
        }
        connectList.sortWith(compareBy { it[0] })
        connectList.forEach {
            if (findParent(parent, it[0]) != findParent(parent, it[1])) {
                sol += 1
                unionParent(parent, it[0], it[1])
            }
        }
        println(sol)
    }
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
