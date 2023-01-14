import java.io.BufferedReader
import java.io.InputStreamReader
data class Pos(val p: Int, val time: Int)

lateinit var visited: BooleanArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var alist= mutableListOf<Int>()
    repeat(n){
        alist.add(br.readLine().toInt())
    }
    alist.sort()
    alist.forEach {
        println(it)
    }

}

