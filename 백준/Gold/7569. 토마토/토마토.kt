import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue

data class Tomato(var h: Int, var m: Int, var n: Int)

fun copyMap(map: Array<Array<IntArray>>, newMap: List<List<IntArray>>, n: Int, m: Int, h: Int): Boolean {
    var changeFlag = false
    for (i in 0 until h) {
        for (j in 0 until m) {
            for (k in 0 until n) {
                if (map[i][j][k] != newMap[i][j][k]) {
                    changeFlag = true
                }
                map[i][j][k] = newMap[i][j][k]
            }
        }
    }
    return changeFlag
}

val nOffset = listOf(0, 0, 1, -1, 0, 0)
val mOffset = listOf(1, -1, 0, 0, 0, 0)
val hOffset = listOf(0, 0, 0, 0, 1, -1)
var nowGoodTomato = 0
fun spreadTomato(
    map: Array<Array<IntArray>>,
    queue: LinkedList<Tomato>,
    n: Int,
    m: Int,
    h: Int
): LinkedList<Tomato> {
    val newQueue = LinkedList<Tomato>()
    while (queue.isNotEmpty()) {
        val curTomato = queue.pop()
        val i = curTomato.h
        val j = curTomato.m
        val k = curTomato.n
        for (index in 0 until 6) {
            val curH = i + hOffset[index]
            val curM = j + mOffset[index]
            val curN = k + nOffset[index]
            if (0 <= curH && curH < h &&
                0 <= curM && curM < m &&
                0 <= curN && curN < n
            ) {
                if (map[curH][curM][curN] == 0) {
                    map[curH][curM][curN] = 1
                    nowGoodTomato += 1
                    newQueue.add(Tomato(curH, curM, curN))

                }
            }
        }
    }


    return newQueue
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, h) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(h) { Array(m) { IntArray(n) } }
    repeat(h) {
        repeat(m) { index ->
            val temp = br.readLine().split(" ").map { it.toInt() }
            map[it][index] = temp.toIntArray()
        }
    }
    var tomatoSum = 0
    var queue = LinkedList<Tomato>()
    for (i in 0 until h) {
        for (j in 0 until m) {
            for (k in 0 until n) {
                if (map[i][j][k] == 1) {
                    queue.add(Tomato(i, j, k))
                    nowGoodTomato += 1
                }
                if (map[i][j][k] != -1) {
                    tomatoSum += 1
                }
            }
        }
    }
    var answer = 0

    while (true) {
        if (nowGoodTomato >= tomatoSum) {
            break
        }
        val newTomato = spreadTomato(map, queue, n, m, h)

        if (newTomato.isEmpty()) {
            answer = -1
            break
        }
        queue = newTomato
        answer += 1
    }
    println(answer)

    br.close()
}
