import java.util.*
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val st1 = StringTokenizer(br.readLine())
    val st2 = StringTokenizer(br.readLine())
    
    val N = st1.nextToken().toInt()
    val X = st1.nextToken().toInt()
    
    for(i in 1 .. N){
        val num = st2.nextToken().toInt() 
        if(num<X){
            bw.write("$num ")
        }
    }
    bw.flush()
    bw.close()
}