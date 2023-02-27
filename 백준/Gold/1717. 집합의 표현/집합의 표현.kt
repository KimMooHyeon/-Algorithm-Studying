import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.DecimalFormat
import kotlin.math.roundToLong
import kotlin.math.sqrt

data class Star(val x: Float, val y: Float)
data class Connect(val x: Int, val y: Int, val distance: Float)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }
    repeat(m) {
        val nList = br.readLine().split(" ").map { it.toInt() }
        when (nList[0]) {
            1 -> {
                //확인
                if (findParent(parent, nList[1]) == findParent(parent, nList[2])) {
                    println("YES")
                }else{
                    println("NO")
                }
            }
            0 -> {
                //합집합
                unionParent(parent, nList[1], nList[2])

            }
            else -> {}
        }
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