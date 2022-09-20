import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (A, B, V) = br.readLine().split(" ").map { it.toInt() }

    val destination = (V - B).toLong()
    val dist = (A - B).toLong()

    val div = destination / dist
    val mod = destination % dist

    var day = div
    if (mod != 0L) {
        day += 1
        println(day)
    } else {
        println(day)
    }
    bw.close()
}

