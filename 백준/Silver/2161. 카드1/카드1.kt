import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val num = br.readLine().toInt()
    val resList = mutableListOf<Int>()
    val res = mutableListOf<Int>()
    for (i in 1..num) {
        resList.add(i)
    }
    while (resList.size != 1) {
        val a = resList[0]
        res.add(a)
        resList.removeAt(0)
        val b = resList.removeAt(0)
        resList.add(b)
    }
    res.add(resList[0])
    println("${res.joinToString(" ")}")
}

