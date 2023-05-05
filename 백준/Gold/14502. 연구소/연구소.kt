import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

val xOffset = listOf<Int>(0, 0, 1, -1)
val yOffset = listOf<Int>(1, -1, 0, 0)
fun spreadVirus(map: Array<IntArray>, virusY: Int, virusX: Int, n: Int, m: Int) {

    for (i in 0..3) {
        val nextX = virusX + xOffset[i]
        val nextY = virusY + yOffset[i]
        if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n) {
            if (map[nextY][nextX] == 0) {
                map[nextY][nextX] = 2
                spreadVirus(map, nextY, nextX, n, m)
            }
        }
    }
}

fun getSafeSpace(map: Array<IntArray>): Int {
    var answer = 0
    map.forEach {
        it.forEach {
            if (it == 0) {
                answer += 1
            }
        }
    }
    return answer
}

var maxNum = 0

fun printMap(map: Array<IntArray>) {
    println()
    map.forEachIndexed { i, v ->
        println(v.contentToString())
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 세로 N, 가로 M
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { mutableListOf<Int>() }
    repeat(n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        map[it] = temp.toMutableList()
    }

    val virusList = mutableListOf<Pair<Int, Int>>()
    val emptyList = mutableListOf<Pair<Int, Int>>()
    map.forEachIndexed { i, v ->
        v.forEachIndexed { index, value ->
            if (value == 2) {
                virusList.add(Pair(i, index))
            } else if (value == 0) {
                emptyList.add(Pair(i, index))
            }
        }
    }
    for (i in 0 until emptyList.size - 2) {
        for (j in i + 1 until emptyList.size - 1) {
            for (k in j + 1 until emptyList.size) {
                map[emptyList[i].first][emptyList[i].second] = 1
                map[emptyList[j].first][emptyList[j].second] = 1
                map[emptyList[k].first][emptyList[k].second] = 1

                val newMap = Array(n) { IntArray(m) }
                for (i in 0 until n){
                    for (j in 0 until m){
                        newMap[i][j]= map[i][j]
                    }
                }
                
                virusList.forEach {
                    spreadVirus(newMap, it.first, it.second, n, m)
                }
                maxNum = maxOf(maxNum, getSafeSpace(newMap))

                map[emptyList[i].first][emptyList[i].second] = 0
                map[emptyList[j].first][emptyList[j].second] = 0
                map[emptyList[k].first][emptyList[k].second] = 0
            }
        }
    }
    println(maxNum)
    br.close()
}
