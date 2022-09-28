import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var (A, B) = br.readLine().split(" ").map { it.toString() }
    var res = 1
    var flag =true
    while (A != B || A.toInt()>B.toInt()) {
        if (B.last()=='1'){
            B = B.substring(0,B.length-1)
            res+=1
            if (B==""){
                flag=false
                break
            }
        }else if (B.last().toInt()%2 != 0){
            flag=false
            break
        }else{
            B=(B.toInt()/2).toString()
            res+=1
        }
    }
    if (flag){
        println(res)
    }else{
        println(-1)
    }
    bw.close()
}


