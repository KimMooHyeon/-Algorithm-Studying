import java.io.BufferedReader
import java.io.InputStreamReader


data class Edge(val start: Int, val end: Int, val distance: Int)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, t) = br.readLine().split(" ").map { it.toInt() }
    var k = t
    var kList = mutableListOf<Int>()


    val connect = mutableListOf<Edge>()

    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        connect.add(Edge(temp[0], temp[1], it + 1))


    }
    connect.sortWith(compareBy { it.distance })
    var updateConnect = connect.sortedWith(compareBy { it.distance }).toMutableList()
    repeat(k) {
        val maxParent = IntArray(n + 1) { it }
        var smallSol: Int = 0
        var edgeNum: Int = 0
        updateConnect = updateConnect.sortedWith(compareBy { it.distance }).toMutableList()
        updateConnect.forEach {
            if (findParent(maxParent, it.start) != findParent(maxParent, it.end)) {
                unionParent(maxParent, it.start, it.end)
                edgeNum += 1
                smallSol += it.distance
            }
        }
        if (edgeNum== n-1){
            kList.add(smallSol)
        }else{
            kList.add(0)
        }

        updateConnect.removeAt(0)
    }
    println(kList.joinToString(" "))
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
