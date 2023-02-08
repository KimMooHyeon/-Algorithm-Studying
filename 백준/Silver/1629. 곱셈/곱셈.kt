import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (A, B, C) = br.readLine().split(" ").map { it.toLong() }

    val ans = pow(A, B, C)

    bw.write(ans.toString())
    bw.close()
}
// pow 2 3
// pow
fun pow(a: Long, b: Long, c: Long): Long {
    when {
        b == 0L -> {
            return 1 
        }
        b == 1L -> {
            return a % c
        }
        b % 2L == 0L -> {
            val num = pow(a, b / 2, c) % c
            return (num * num) % c
        }
        b % 2L == 1L -> {
            val num = pow(a, b / 2, c) % c
            return (((num * num) % c) * a) % c
        }
        else -> {
            return -1
        }
    }
}
