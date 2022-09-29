import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet

data class Person(var trueInfo: Boolean, val nameNumber: Int)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val T =br.readLine().toInt()

    for (i in  1.. T){
        val numList = br.readLine().split(" ").map { it.toInt() }
        bw.write("${numList.sorted()[7]}\n")
    }
    bw.close()
}

