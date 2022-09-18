import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val num = br.readLine() ?: break
        if (num == "0 0"){
            break
        }
        bw.write("${num.split(" ").sumOf { it.toInt() }}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}

