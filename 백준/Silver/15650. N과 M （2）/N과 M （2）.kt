import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {


    val (N,M) = br.readLine().split(" ").map { it.toInt() }
    dfs(1,N,M, mutableListOf())
    bw.close()
}
fun dfs(startIndex:Int,N:Int,M:Int,list:MutableList<Int>){
    if (list.size==M){
        println(list.joinToString(" "))
        return
    }
    if (startIndex>N){
        return
    }
    for(i in startIndex .. N){
        if (i !in list){
            list.add(i)
            dfs(i,N,M,list)
            list.remove(i)
        }

    }
}