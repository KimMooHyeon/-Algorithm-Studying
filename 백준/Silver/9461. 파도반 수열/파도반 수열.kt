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
    val T = br.readLine().toInt()
    for (i in 1..T) {
        val N = br.readLine().toInt()

        if (N < 5) {
            val nList = LongArray(5)
            nList[1] = 1
            nList[2] = 1
            nList[3] = 1
            nList[4] = 2
            println(nList[N])
        } else {
            val nList = LongArray(N + 1)
            nList[1] = 1
            nList[2] = 1
            nList[3] = 1
            nList[4] = 2
            for (i in 5..N) {

                nList[i] = nList[i - 2] + nList[i - 3]
            }
            println(nList[N])
        }
    }

    br.close()
    bw.close()
}


