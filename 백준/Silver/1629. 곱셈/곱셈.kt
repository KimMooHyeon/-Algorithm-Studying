import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (A,B,C) = br.readLine().split(" ").map { it.toLong() }
    
    var ans = pow(A,B,C)
    bw.write(ans.toString())
    bw.close()
}
fun pow(base:Long,expo:Long,mod:Long): Long {
    if(expo==1L)
        return base%mod

    val temp = pow(base,expo/2,mod)

    if(expo%2==0L){
        return (temp*temp)%mod
    }
    return ((temp*temp)%mod*base)%mod
}
