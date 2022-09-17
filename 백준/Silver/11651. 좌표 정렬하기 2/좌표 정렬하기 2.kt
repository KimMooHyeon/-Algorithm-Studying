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
    val nList = mutableListOf<Pair<Int,Int>>()
    for (i in 0 until N){
        val (x,y) = br.readLine().split(" ")
        nList.add(Pair(x.toInt(),y.toInt()))
    }
    nList.sortWith(compareBy<Pair<Int, Int>> {it.second}.thenBy { it.first})
    nList.map { bw.write("${it.first} ${it.second}\n") }
    br.close()
    bw.close()
}
