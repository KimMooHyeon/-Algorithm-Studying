import java.util.*
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var max = 0
    var index=0
    for (i in 0 .. 8){
        val num = StringTokenizer(br.readLine()).nextToken().toInt()
        if (num>max){
            max = num
            index =i+1
        }
    }
    bw.write("${max}\n${index}")
    bw.flush()
    bw.close()
}