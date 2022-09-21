import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val resList = TreeSet<Int>()

    for (i in 1..N) {
        if (isRight(i, N)) {
            resList.add(i)
        }
    }
    if (resList.isNotEmpty()){
        println(resList.first())
    }else{
        println("0")
    }
    br.close()
    bw.close()

}

fun isRight(i: Int, N: Int): Boolean {
    var res = false
    var sum = i
    var a = i
    while (true) {
        val b = a % 10
        sum += b
        if (a / 10 < 1) {
            break
        } else {
            a /= 10
        }
    }
    if (sum == N) {
        res = true
    }
    return res
}

