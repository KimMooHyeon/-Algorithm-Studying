import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    bw.write("${st.nextToken().toInt()+st.nextToken().toInt()}")
    bw.flush()
    bw.close()
}