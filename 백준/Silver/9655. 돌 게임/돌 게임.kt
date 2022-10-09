import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val num = br.readLine().toInt()
    if (num%2==0){
        println("CY")
    }else{
        println("SK")
    }
    // 1 상근
    // 2 창영
    // 3 상근
    // 4 창영
    // 5 상근

    bw.close()
}

