import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    //val num = br.readLine().split(" ").map { it.toInt()*it.toInt() }.sum()%10

    val time = br.readLine().split(" ").map { it.toInt() }
    var min =0
    min = if (time[0] == 0 && time[1] < 45) {
        24*60+time[1]-45
    } else {
        time[0] * 60 + time[1] - 45
    }
    bw.write("${min/60} ${min%60}")
    bw.close()
    br.close()
}

