import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue

data class Point(val y: Int, val x: Int)

lateinit var answer: Array<LongArray>
lateinit var mapNum: Array<LongArray>
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

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    answer = Array(n) { LongArray(m) }
    map = Array(n) { LongArray(m) }
    mapNum = Array(n) { LongArray(m) }
    mapVisitPossible = Array(n) { BooleanArray(m) { true } }
    val wallList = LinkedList<Point>()
    val emptyList = LinkedList<Point>()
    repeat(n) { y ->
        val temp = br.readLine().split("")
        var num = 0
        temp.forEachIndexed { i, v ->
            if (isInteger(v)) {
                map[y][num] = v.toLong()
                num += 1
            }
        }
        //map[y] = temp.subList(1, 1 + m).map { it.toInt() }.toIntArray()
        map[y].forEachIndexed { x, v ->
            if (v == 0L) {
                emptyList.add(Point(y, x))
            } else if (v == 1L) {
                wallList.add(Point(y, x))
                answer[y][x]=1
            }
        }
    }

    while (emptyList.isNotEmpty()) {
        val curPoint = emptyList.poll()
        if (mapVisitPossible[curPoint.y][curPoint.x]) {
            bfs(curPoint, n, m)
        }
    }
    answer.forEach {
        println(it.map { it % 10 }.joinToString(""))
    }

    br.close()
}

val xOffset = listOf(0, 0, 1, -1)
val yOffset = listOf(1, -1, 0, 0)


fun bfs(curPoint: Point, n: Int, m: Int) {

    val queue = LinkedList<Point>()
    val addQueue = mutableSetOf<Point>()
    var num: Long = 0
    num += 1
    queue.add(curPoint)
    mapVisitPossible[curPoint.y][curPoint.x] = false
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (i in 0..3) {
            val nextY = cur.y + yOffset[i]
            val nextX = cur.x + xOffset[i]
            if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                if (map[nextY][nextX] == 1L) {
                    addQueue.add(Point(nextY, nextX))
                    continue
                }
                if (mapVisitPossible[nextY][nextX]) {
                    if (map[nextY][nextX] == 0L) {
                        mapVisitPossible[nextY][nextX] = false
                        queue.add(Point(nextY, nextX))
                        num += 1
                    }
                }
            }
        }
    }
    addQueue.forEach {
        answer[it.y][it.x] += num
    }
}