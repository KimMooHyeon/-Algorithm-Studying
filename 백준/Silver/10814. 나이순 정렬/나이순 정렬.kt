import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet

data class User(val age : Int,val join : Int, val name:String)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val resList = mutableListOf<User>()
    for(i in 0  until N ){
        val input=br.readLine().split(" ")
        resList.add(User(input[0].toInt(),i,input[1]))
    }
    resList.sortWith(compareBy<User> {it.age}.thenBy { it.join })
    resList.map {
        bw.write("${it.age} ${it.name}")
        bw.newLine()
    }
    bw.close()
}