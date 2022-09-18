import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine()
    for (i in 1 .. N.toInt()){
        for (j in 1 .. i){
            bw.write("*")
        }
        bw.newLine()
    }
    bw.close()
    br.close()
}

