import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val pq = mutableListOf<Int>()
    for (i in 1..N) {
        val x = br.readLine().toInt()
        pq.add(x)
    }
    pq.sortDescending()
    var max = pq[0]
    var sum = pq[0]
    for (i in 1 until pq.size) {
        var temp = sum + pq[i]
        if (temp.toDouble() / (i + 1) > pq[i].toDouble()) {
            temp = pq[i] * (i + 1)
        }

        if (temp > max) {
            max = temp
            sum = temp
        }
    }
    println(max)
}



