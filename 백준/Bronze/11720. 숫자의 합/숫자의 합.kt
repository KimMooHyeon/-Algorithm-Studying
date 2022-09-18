import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    var res = 0
    val num = br.readLine().map { it.toString() }
    for (i in num){
        res+=i.toInt()
    }
    bw.write(res.toString())
    bw.flush()
    bw.close()
    br.close()
}

