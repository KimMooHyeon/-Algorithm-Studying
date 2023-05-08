import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue

data class Tomato(var m: Int, var n: Int)

val nOffset = listOf(0, 0, 1, -1)
val mOffset = listOf(1, -1, 0, 0)
var nowGoodTomato = 0
fun spreadTomato(
    map: Array<IntArray>,
    queue: LinkedList<Tomato>,
    n: Int,
    m: Int
): LinkedList<Tomato> {
    val newQueue = LinkedList<Tomato>()
    while (queue.isNotEmpty()) {
        val curTomato = queue.pop()
        val j = curTomato.m
        val k = curTomato.n
        for (index in 0 until 4) {

            val curM = j + mOffset[index]
            val curN = k + nOffset[index]
            if (
                0 <= curM && curM < m &&
                0 <= curN && curN < n
            ) {
                if (map[curM][curN] == 0) {
                    map[curM][curN] = 1
                    nowGoodTomato += 1
                    newQueue.add(Tomato( curM, curN))

                }
            }
        }
    }


    return newQueue
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(m) { IntArray(n) }

        repeat(m) { index ->
            val temp = br.readLine().split(" ").map { it.toInt() }
            map[index] = temp.toIntArray()
        }

    var tomatoSum = 0
    var queue = LinkedList<Tomato>()

        for (j in 0 until m) {
            for (k in 0 until n) {
                if (map[j][k] == 1) {
                    queue.add(Tomato( j, k))
                    nowGoodTomato += 1
                }
                if (map[j][k] != -1) {
                    tomatoSum += 1
                }
            }
        }

    var answer = 0

    while (true) {
        if (nowGoodTomato >= tomatoSum) {
            break
        }
        val newTomato = spreadTomato(map, queue, n, m)

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
