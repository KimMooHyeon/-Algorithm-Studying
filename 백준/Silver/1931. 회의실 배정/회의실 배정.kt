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
    val N = br.readLine().toInt()
    val nList =mutableListOf<Pair<Int,Int>>()

    for (i in 1 .. N){
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        nList.add(Pair(a,b))
    }
    nList.sortWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
    var finish=nList[0].second
    var count=1

    for (i in 1 until  nList.size){
        if (finish<=nList[i].first){
            count+=1
            finish=nList[i].second
        }
    }
    println(count)
    bw.close()
}

