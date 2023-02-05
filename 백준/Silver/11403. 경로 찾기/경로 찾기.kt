import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val connect = Array(n) { IntArray(n) { Int.MAX_VALUE } }

    repeat(n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        temp.forEachIndexed { index, v ->
            connect[it][index] = v
        }
    }
    for (k in 0 until  n){
        for (i in 0 until  n){
            for (j in 0 until  n){
                if (connect[i][k] == 0 || connect[k][j] == 0){
                    continue
                }
                connect[i][j] = 1
            }
        }
    }

    connect.forEach {
        println(it.joinToString(" "))
    }

    br.close()
    bw.close()
}

