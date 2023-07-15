import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val a = br.readLine().trim().toBigInteger()
    val b = br.readLine().trim().toBigInteger()
    println(a + b)
    println(a - b)
    println(a * b)
    br.close()
}