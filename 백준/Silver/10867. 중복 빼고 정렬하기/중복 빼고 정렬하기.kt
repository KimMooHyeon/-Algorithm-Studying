import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.TreeMap
import java.util.TreeSet

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val nList = TreeSet<Int>()
    val temp = br.readLine().split(" ")
    temp.map { nList.add(it.toInt()) }

    bw.write(nList.joinToString(" "))
    br.close()
    bw.close()
}
