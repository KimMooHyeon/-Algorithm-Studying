import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    println(fac(N)/(fac(K)*fac(N-K)))
}

fun fac(num : Int):Int{
    var res= 1
    for (i in 1 .. num){
        res*=i
    }
    return res
}