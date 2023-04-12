import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

data class Edge(val edgeNumber: Int, val startIndex: Int, val destIndex: Int)

fun unionFind(parent: IntArray, x: Int, y: Int) {
    val xParent = findParent(parent, x)
    val yParent = findParent(parent, y)

    if (xParent < yParent) {
        parent[yParent] = xParent
    } else {
        parent[xParent] = yParent
    }
}

fun findParent(parent: IntArray, x: Int): Int {
    if (parent[x] == x) {
        return x
    } else {
        parent[x] = findParent(parent, parent[x])
        return parent[x]
    }
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val edgeList = LinkedList<Edge>()
    val parent = IntArray(N + 1) { it }

    repeat(M) { edgeNumber ->
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        edgeList.add(Edge(edgeNumber, u, v))
        if (findParent(parent, u) != findParent(parent, v)) {
            unionFind(parent, u, v)
        }
    }
    var answer = 0
    val hash = HashMap<Int, Boolean>()
    for (i in 1..N) {
        if (findParent(parent, i) !in hash) {
            hash[findParent(parent, i)] = true
            answer += 1
        }
    }
    println(answer)

    br.close()
    bw.close()
}
// 간선
// [1] 2, 3
// [2] 1, 3
// [3] 1 ,2, 4
// [4] 3, 5
// [5] 4