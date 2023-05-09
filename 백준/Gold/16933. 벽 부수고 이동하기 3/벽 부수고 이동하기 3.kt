import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

data class PointCost(val y: Int, val x: Int, val cost: Int, var useChancePossible: Int, var isNight: Boolean)

lateinit var dpMorningMap: Array<Array<LongArray>>
lateinit var dpNightMap: Array<Array<LongArray>>
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
        queue.add(PointCost(0, 0, 1, k - 1, true))
    } else {
        queue.add(PointCost(0, 0, 1, k, true))
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
        val todayTime = !curPoint.isNight
        if (todayTime) {
            //밤
            //벽 부수기 불가능
            // 찬스 사용 불가능
            if (curPoint.useChancePossible > 0) {
                //찬스 사용가능
                for (i in 0..3) {
                    val nextY = curPoint.y + yOffset[i]
                    val nextX = curPoint.x + xOffset[i]
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (map[nextY][nextX] == 0L) {
                            if (dpMorningMap[curPoint.useChancePossible][nextY][nextX] > curPoint.cost + 1) {
                                dpMorningMap[curPoint.useChancePossible][nextY][nextX] = curPoint.cost + 1L
                                queue.add(
                                    PointCost(
                                        nextY,
                                        nextX,
                                        curPoint.cost + 1,
                                        curPoint.useChancePossible,
                                        todayTime
                                    )
                                )
                            }
                        } else {
                            if (dpMorningMap[curPoint.useChancePossible][curPoint.y][curPoint.x] > curPoint.cost + 1) {
                                dpMorningMap[curPoint.useChancePossible][curPoint.y][curPoint.x] = curPoint.cost + 1L
                                queue.add(
                                    PointCost(
                                        curPoint.y,
                                        curPoint.x,
                                        curPoint.cost + 1,
                                        curPoint.useChancePossible,
                                        todayTime
                                    )
                                )
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
                            if (dpNightMap[curPoint.useChancePossible][nextY][nextX] > curPoint.cost + 1) {
                                dpNightMap[curPoint.useChancePossible][nextY][nextX] = curPoint.cost + 1L
                                queue.add(
                                    PointCost(
                                        nextY,
                                        nextX,
                                        curPoint.cost + 1,
                                        curPoint.useChancePossible,
                                        todayTime
                                    )
                                )
                            }
                        }
                    }
                }
            }
        } else {
            //낮
            //벽 부수기 가능
            if (curPoint.useChancePossible > 0) {
                //찬스 사용가능
                for (i in 0..3) {
                    val nextY = curPoint.y + yOffset[i]
                    val nextX = curPoint.x + xOffset[i]
                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (map[nextY][nextX] == 0L) {
                            if (dpNightMap[curPoint.useChancePossible][nextY][nextX] > curPoint.cost + 1) {
                                dpNightMap[curPoint.useChancePossible][nextY][nextX] = curPoint.cost + 1L
                                queue.add(
                                    PointCost(
                                        nextY,
                                        nextX,
                                        curPoint.cost + 1,
                                        curPoint.useChancePossible,
                                        todayTime
                                    )
                                )
                            }
                        } else {
                            if (dpNightMap[curPoint.useChancePossible][nextY][nextX] > curPoint.cost + 1) {
                                dpNightMap[curPoint.useChancePossible][nextY][nextX] = curPoint.cost + 1L
                                queue.add(
                                    PointCost(
                                        nextY,
                                        nextX,
                                        curPoint.cost + 1,
                                        curPoint.useChancePossible - 1,
                                        todayTime
                                    )
                                )
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
                            if (dpMorningMap[curPoint.useChancePossible][nextY][nextX] > curPoint.cost + 1) {
                                dpMorningMap[curPoint.useChancePossible][nextY][nextX] = curPoint.cost + 1L
                                queue.add(
                                    PointCost(
                                        nextY,
                                        nextX,
                                        curPoint.cost + 1,
                                        curPoint.useChancePossible,
                                        todayTime
                                    )
                                )
                            }
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
    dpMorningMap = Array(k + 1) { Array(n) { LongArray(m) { Long.MAX_VALUE } } }
    dpNightMap = Array(k + 1) { Array(n) { LongArray(m) { Long.MAX_VALUE } } }
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
