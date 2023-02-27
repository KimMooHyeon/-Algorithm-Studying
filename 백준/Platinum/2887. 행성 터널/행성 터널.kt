import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val xQueue = PriorityQueue<IntArray>(Comparator { o1, o2 -> o1[0] - o2[0] })
    val yQueue = PriorityQueue<IntArray>(Comparator { o1, o2 -> o1[1] - o2[1] })
    val zQueue = PriorityQueue<IntArray>(Comparator { o1, o2 -> o1[2] - o2[2] })
    val br = BufferedReader(InputStreamReader(System.`in`))

    var sol = 0
    val n = br.readLine().toInt()
    val planetList = Array(n + 1) { IntArray(4) }
    val parent = IntArray(n + 1) { it }
    val connectList = mutableListOf<IntArray>()

    repeat(n) { index ->
        val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
        val planet = intArrayOf(x, y, z, index + 1)
        planetList[index + 1] = planet
        xQueue.add(planet)
        yQueue.add(planet)
        zQueue.add(planet)
    }
    planetList[0] = intArrayOf(0, 0, 0, -1)

    val xTemp = mutableListOf<IntArray>()
    val yTemp = mutableListOf<IntArray>()
    val zTemp = mutableListOf<IntArray>()

    while (xQueue.isNotEmpty()) {
        xTemp.add(xQueue.poll())
    }
    while (yQueue.isNotEmpty()) {
        yTemp.add(yQueue.poll())
    }
    while (zQueue.isNotEmpty()) {
        zTemp.add(zQueue.poll())
    }

    for (i in 0 until n-1){
        connectList.add(intArrayOf(xTemp[i][3], xTemp[i + 1][3], abs(xTemp[i + 1][0] - xTemp[i][0])))
    }
    for (i in 0 until n-1){
        connectList.add(intArrayOf(yTemp[i][3], yTemp[i + 1][3], abs(yTemp[i + 1][1] - yTemp[i][1])))
    }
    for (i in 0 until n-1){
        connectList.add(intArrayOf(zTemp[i][3], zTemp[i + 1][3], abs(zTemp[i + 1][2] - zTemp[i][2])))
    }

    connectList.sortWith(compareBy { it[2] })

    connectList.forEach {
        if (findParent(parent, it[0]) != findParent(parent, it[1])) {
            unionParent(parent, it[0], it[1])
            sol += it[2]
        }
    }
    print(sol)
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
