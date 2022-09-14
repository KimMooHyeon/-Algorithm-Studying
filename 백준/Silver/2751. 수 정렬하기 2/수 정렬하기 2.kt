import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val tempList = TreeSet<Int>()
    for (i in 1 .. N){
        tempList.add(br.readLine().toInt())
    }
    tempList.map { bw.write("$it\n") }
    bw.flush()
    bw.close()
}
