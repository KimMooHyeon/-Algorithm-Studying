import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (a,b) = br.readLine()!!.split(" ").map { it.toBigInteger() }
    println(a/b)
    println(a%b)
}