import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    //val num = br.readLine().split(" ").map { it.toInt()*it.toInt() }.sum()%10

    val year =br.readLine().toInt()
    if ((year%4==0 && year%100 !=0) ||year%400 ==0 ){
        bw.write("1")
    }else{
        bw.write("0")
    }


    bw.close()
    br.close()
}

