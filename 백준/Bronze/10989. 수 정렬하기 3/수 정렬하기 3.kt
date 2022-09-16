import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeMap
import java.util.TreeSet

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N: Int = br.readLine().toInt()

    val array = IntArray(10001)

    for (i in 0 until N) {
        array[br.readLine().toInt()]++
    }
    br.close()

    for (i in array.indices) {
        bw.write("$i\n".repeat(array[i]))
    }
    bw.close()
}
