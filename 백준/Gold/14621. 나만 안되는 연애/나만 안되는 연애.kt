import java.io.BufferedReader
import java.io.InputStreamReader


data class Edge(val start: Int, val end: Int, val distance: Int)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }


    val parent = IntArray(n + 1) { it }
    val wmMap = Array<String>(n + 1) { "" }
    val connect = mutableListOf<Edge>()
    val wm = br.readLine().split(" ").map { it.toString() }
    for (i in 1..n) {
        wmMap[i] = wm[i - 1]
    }
    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        if (wmMap[temp[0]] != wmMap[temp[1]]) connect.add(Edge(temp[0], temp[1], temp[2]))
    }

    var sol = 0
    var edgeNum =0
    connect.sortWith(compareBy { it.distance })
    connect.forEach {
        if (findParent(parent, it.start) != findParent(parent, it.end) && wmMap[it.start] != wmMap[it.end]) {
            unionParent(parent, it.start, it.end)
            edgeNum+=1
            sol += it.distance
        }
    }
    if (sol == 0 || edgeNum!= n-1) {
        println(-1)
    } else {
        println(sol)
    }
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
