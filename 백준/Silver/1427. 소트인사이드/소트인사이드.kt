import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N =br.readLine()
    val a = mutableListOf<Int>()
    N.forEach {
        a.add(it.toString().toInt())
    }
    println(a.sorted().reversed().joinToString(""))
    bw.close()
}

