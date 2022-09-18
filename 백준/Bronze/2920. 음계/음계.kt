import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().split(" ")
    val ascending = mutableListOf<Int>()
    val descending = mutableListOf<Int>()
    for (i in 1..8) {
        ascending.add(i)
        descending.add(9 - i)
    }
    if (N.joinToString("") == ascending.joinToString("")) {
        bw.write("ascending")
    } else if (N.joinToString("") == descending.joinToString("")) {
        bw.write("descending")
    }else{
        bw.write("mixed")
    }


    bw.close()
    br.close()
}

