import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toInt() }
    val M = br.readLine().toInt()
    val mList = br.readLine().split(" ").map { it.toInt() }
    val hs = HashSet<Int>()
    
    nList.map { hs.add(it) }
    mList.map {
        if (it in hs) {
            bw.write("${1} ")
        } else {
            bw.write("${0} ")
        }
    }
    bw.flush()
    bw.close()
}
