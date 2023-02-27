import java.io.BufferedReader
import java.io.InputStreamReader

data class Connect(val x: Int, val y: Int, val distance: Int)

val edgeList = mutableListOf<Connect>()

//val homeList = mutableSetOf<Int>()
lateinit var booleanArray: BooleanArray
var sol = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val kList = br.readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }
    booleanArray = BooleanArray(n + 1) { false }
/*
    repeat(n) {
        homeList.add(it + 1)
    }
    */
    kList.forEach {
        booleanArray[it]= true
    }
    repeat(m) { index ->
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        edgeList.add(Connect(u, v, w))
    }
    edgeList.sortWith(compareBy { it.distance })


    edgeList.forEach {
        if (booleanArray[findParent(parent, it.x)] && booleanArray[findParent(parent, it.y)]) {
        } else {
            if (findParent(parent, it.x) != findParent(parent, it.y)) {
                unionParent(parent, it.x, it.y)
                sol += it.distance
            }
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
        if (booleanArray[xParent]){
            parent[yParent] = xParent
        }else if (booleanArray[yParent]){
            parent[xParent] = yParent
        }else{
            if (xParent < yParent) {
                parent[yParent] = xParent
            } else {
                parent[xParent] = yParent
            }
        }
}
