import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N,k) = br.readLine().split(" ")
    val scoreList = br.readLine().split(" ").map { it.toInt() }.sortedDescending()

    println(scoreList[k.toInt()-1])

}
