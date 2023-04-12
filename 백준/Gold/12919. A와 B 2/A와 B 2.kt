import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var flag = false
var endFlag = false
fun dfs(A: List<String>, B: List<String>) {
    if (flag){
        return
    }
    if (B.isEmpty()){
        endFlag = true
        return
    }
    if (A == B) {
        endFlag = true
        flag = true
        return
    }else{
        if (B[B.size-1]=="A"){
            dfs(A,B.subList(0,B.size-1))
        }
        if (B[0]=="B"){
            dfs(A,B.subList(1,B.size).reversed())
        }
    }
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val A = br.readLine().toList().map { it.toString() }
    val B = br.readLine().toList().map { it.toString() }
    dfs(A, B)
    if (flag) {
        println(1)
    } else {
        println(0)
    }
    br.close()
    bw.close()
}