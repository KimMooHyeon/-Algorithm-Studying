import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val num = br.readLine().toInt()

    val numString = Integer.toBinaryString(num+1)

    numString.subSequence(1,numString.length).forEach {
        if (it=='0'){
            print("4")
        }else{
            print("7")
        }
    }
    bw.close()
}

