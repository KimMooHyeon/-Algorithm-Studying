import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val heap = PriorityQueue<Int>()
    for (i in 1..N) {
        val num = br.readLine().toInt()
        when (num) {
            0 -> {
                if (heap.isEmpty()) {
                    bw.write("0\n")
                } else {
                    val num = heap.poll()
                    bw.write("${num}\n")
                }
            }
            else -> {
                heap.offer(num)
            }
        }
    }
    br.close()
    bw.close()
}


