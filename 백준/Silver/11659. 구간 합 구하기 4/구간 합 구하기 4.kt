import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val nList = br.readLine().split(" ").map { it.toInt() }
    var res=0
    val sumList= mutableListOf<Int>()
    sumList.add(0)
    nList.forEach {
        res+=it
        sumList.add(res)
    }
    for (i in 1..M) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${sumList[j]-sumList[i-1]}\n")
    }
    br.close()
    bw.close()
}


