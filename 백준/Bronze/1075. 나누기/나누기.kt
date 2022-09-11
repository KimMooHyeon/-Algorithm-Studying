import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine()
    val F = br.readLine().toInt()
    val res = 0
    for (i in 0..99) {
        var num = N.substring(0, N.length-2)
        if (i < 10) {
            num += ("0$i")
            if (num.toInt() % F == 0) {
                bw.write("0$i")
                bw.flush()
                bw.close()
                break
            }
        } else {
            num += i.toString()
            if (num.toInt() % F == 0) {
                bw.write("$i")
                bw.flush()
                bw.close()
                break
            }
        }
    }
}