import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val ts = TreeSet<Int>()

    for (i in 0 until 10){
        ts.add(br.readLine().toInt()%42)
    }
    bw.write(ts.size.toString())
    bw.close()
    br.close()
}

