import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val num = br.readLine().split(" ").map { it.toInt()*it.toInt() }.sum()%10

    bw.write(num.toString())

    bw.close()
    br.close()
}

