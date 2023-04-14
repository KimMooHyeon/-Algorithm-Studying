import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.collections.HashMap

data class Point(val y: Int, val x: Int)
lateinit var hashList :Array<LongArray>
val tempNumber :Long = (10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10) +7
// 짝수 일때 아래, 오른쪽, 오른쪽 위
val evenXOffset = listOf<Int>(0, -1, -1)
val evenYOffset = listOf<Int>(-1, 0, 1)

// 홀수 일때, 아래, 오른쪽, 오른쪽 아래
val oddXOffset = listOf<Int>(0, -1, -1)
val oddYOffset = listOf<Int>(-1, 0, -1)

fun dfs(map: Array<IntArray>, y: Int, x: Int, ySize: Int, xSize: Int): Long {
    if (hashList[y][x]!=-1L){
        return hashList[y][x]
    }
    if (y == 0 && x == 0) {
        return 1
    }
    if (map[y][x] == -1) {
        return 0
    }
    if (x % 2 == 0) {
        //짝수일때
        var sum: Long = 0
        for (i in 0..2) {
            val beforeX = x + oddXOffset[i]
            val beforeY = y + oddYOffset[i]
            if (0 <= beforeX && beforeX < xSize && 0 <= beforeY && beforeY < ySize) {
           //     val temp = Point(beforeY, beforeX)
                if (hashList[beforeY][beforeX]!=-1L){
                    sum +=  hashList[beforeY][beforeX]
                } else {
                    sum += dfs(map, beforeY, beforeX, ySize, xSize)%tempNumber
                }
            }
        }
        hashList[y][x] = sum%tempNumber
      //  hash[Point(y, x)] = sum%tempNumber
        return sum%tempNumber
    } else {
        //홀수일때
        var sum: Long = 0
        for (i in 0..2) {
            val beforeX = x + evenXOffset[i]
            val beforeY = y + evenYOffset[i]
            if (0 <= beforeX && beforeX < xSize && 0 <= beforeY && beforeY < ySize) {
                if (hashList[beforeY][beforeX]!=-1L){
                    sum +=  hashList[beforeY][beforeX]
                } else {
                    sum += dfs(map, beforeY, beforeX, ySize, xSize)%tempNumber
                }
            }
        }
        hashList[y][x] = sum%tempNumber
        return sum%tempNumber
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    hashList = Array(n) { LongArray(m){-1L} }
    val k = br.readLine().toInt()
    repeat(k) {
        val (_y, _x) = br.readLine().split(" ").map { it.toInt() }
        map[_y - 1][_x - 1] = -1
    }
    map[0][0] = 1


    val sol: Long = dfs(map, map.size - 1, map[0].size - 1, map.size, map[0].size)
    println(sol % tempNumber)

    br.close()
    bw.close()
}