import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    for (i in 0 until N){
        bw.write("${br.readLine().split(" ").sumOf { it.toInt() }}\n")
    }
    bw.close()
    br.close()
}

