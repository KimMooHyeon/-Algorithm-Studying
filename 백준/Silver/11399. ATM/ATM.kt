import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

var rList = mutableListOf<Int>()
var gList = mutableListOf<Int>()
var bList = mutableListOf<Int>()
var N = 0
var minNum = -1
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    N = br.readLine().toInt()
    var pList = br.readLine().split(" ").map { it.toInt() }
    pList = pList.sorted()
    //println(pList.toString())

    var time = 0
    var sum =0
    for (i in pList){
        time+=i
        sum+=time
    }
    println(sum)

    br.close()
    bw.close()
}

