import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

data class Point(val y: Int, val x: Int)
data class PointCost(val y: Int, val x: Int, val cost: Int, var useChancePossible: Int)


lateinit var dpMap: Array<Array<LongArray>>
lateinit var mapVisitPossible: Array<BooleanArray>
lateinit var map: Array<LongArray>

fun isInteger(s: String): Boolean {
    return try {
        s.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

val xOffset = listOf(0, 0, 1, -1)
val yOffset = listOf(1, -1, 0, 0)
var answer = -1
fun bfs(n: Int, m: Int, k: Int) {
    val queue = LinkedList<PointCost>()
    if (map[0][0] == 1L) {
        queue.add(PointCost(0, 0, 1, k - 1))
    } else {
        queue.add(PointCost(0, 0, 1, k))
    }


    while (queue.isNotEmpty()) {
        val curPoint = queue.poll()
        if (curPoint.y == n - 1 && curPoint.x == m - 1) {
            if (answer == -1) {
                answer = curPoint.cost
            } else {
                answer = minOf(curPoint.cost, answer)
            }
            continue
        }
        if (curPoint.useChancePossible>0) {
            //찬스 사용가능
            for (i in 0..3) {
                val nextY = curPoint.y + yOffset[i]
                val nextX = curPoint.x + xOffset[i]
                if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                    if (map[nextY][nextX] == 0L) {
                        if (dpMap[curPoint.useChancePossible][nextY][nextX] > curPoint.cost + 1) {
                            dpMap[curPoint.useChancePossible][nextY][nextX] = curPoint.cost + 1L
                            queue.add(PointCost(nextY, nextX, curPoint.cost + 1, curPoint.useChancePossible))
                        }
                    } else {
                        if (dpMap[curPoint.useChancePossible][nextY][nextX] > curPoint.cost + 1) {
                            dpMap[curPoint.useChancePossible][nextY][nextX] = curPoint.cost + 1L
                            queue.add(PointCost(nextY, nextX, curPoint.cost + 1, curPoint.useChancePossible-1))
                        }
                    }
                }
            }
        } else {
            // 찬스 사용 불가능
            for (i in 0..3) {
                val nextY = curPoint.y + yOffset[i]
                val nextX = curPoint.x + xOffset[i]
                if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                    if (map[nextY][nextX] == 0L) {
                        if (dpMap[curPoint.useChancePossible][nextY][nextX] > curPoint.cost + 1) {
                            dpMap[curPoint.useChancePossible][nextY][nextX] = curPoint.cost + 1L
                            queue.add(PointCost(nextY, nextX, curPoint.cost + 1, curPoint.useChancePossible))
                        }
                    }
                }
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n) { LongArray(m) }
    dpMap = Array(k + 1) { Array(n) { LongArray(m) { Long.MAX_VALUE } } }

    mapVisitPossible = Array(n) { BooleanArray(m) { true } }

    repeat(n) { y ->
        val temp = br.readLine().split("")
        var num = 0
        temp.forEachIndexed { i, v ->
            if (isInteger(v)) {
                map[y][num] = v.toLong()
                num += 1
            }
        }
    }

    bfs(n, m, k)
    println(answer)

    br.close()
}
