import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (A, B) = br.readLine().split(" ").map { it.toInt() }

    var divisor = 0
    var multiple = 0
    if (A > B) {
        for (i in B downTo 1 ) {
            if (B % i == 0 && A % i == 0) {
                divisor = i
                multiple = divisor * (B / divisor) * (A / divisor)
                break
            }
        }
    } else {
        for (i in A downTo 1 ) {
            if (B % i == 0 && A % i == 0) {
                divisor = i
                multiple = divisor * (B / divisor) * (A / divisor)
                break
            }
        }
    }
    println(divisor)
    println(multiple)
}
