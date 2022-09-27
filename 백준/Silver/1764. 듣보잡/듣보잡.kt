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
    val hs = HashMap<String,Int>()
    val s = mutableListOf<String>()
    for (i in 1 .. N ){
        hs[br.readLine().toString()]=0
    }
    for (i in 1 .. M ){
        val input =br.readLine().toString()
        if (hs[input]==0){
            s.add(input)
        }
    }

    println(s.size)
    s.sort()
    s.forEach {
        println(it)
    }

}


