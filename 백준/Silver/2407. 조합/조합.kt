import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toBigInteger() }


    var res : BigInteger = 1.toBigInteger()
    for (i in (n.toInt()-m.toInt()+1).toInt() .. n.toInt() ){
        res*=i.toBigInteger()
    }
    var down:BigInteger =1.toBigInteger()
    for(i in m.toInt() downTo 1){
        down*=i.toBigInteger()
    }
    println((res/down) )
    bw.close()
}

/*
100 99 98 97 96 95 94
                  94 93 92 */
