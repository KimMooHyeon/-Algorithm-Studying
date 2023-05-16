import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val answer = mutableListOf<Int>()
    repeat(n) {
        answer.add(br.readLine().toInt())
    }
    answer.sortDescending()
    answer.forEach {
        bw.write("$it\n")
    }

    bw.close()
}

