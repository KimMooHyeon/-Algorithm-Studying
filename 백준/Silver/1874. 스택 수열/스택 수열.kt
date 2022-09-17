import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.TreeMap
import java.util.TreeSet

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb =StringBuilder()
    val n = br.readLine().toInt()
    val stack = mutableListOf<Int>()
    val nList = mutableListOf<Int>()
    val popList = mutableListOf<Int>()
    for (i in 0 until n) {
        nList.add(br.readLine().toInt())
    }
    val resList = nList.joinToString(" ")
    var index = 0
    for (i in 1..n) {
        if (index>=nList.size) break
        if (nList[index] > i) {
            stack.add(i)
            sb.append("+\n")
        } else if (nList[index] == i) {
            stack.add(i)
            sb.append("+\n")
            val pop =stack.removeLast()
            popList.add(pop)
            sb.append("-\n")
            index += 1
        } else if (nList[index] < i) {
            while (stack.isNotEmpty() && index<nList.size){
                if (nList[index] == stack.last()){
                    index+=1
                    val pop = stack.removeLast()
                    sb.append("-\n")
                    popList.add(pop)
                }else{
                    break
                }
            }
            stack.add(i)
            sb.append("+\n")
        }
    }
    while (stack.isNotEmpty()) {
        val pop = stack.removeLast()
        popList.add(pop)
        sb.append("-\n")
    }

    if (resList == popList.joinToString(" ")) {
        println(sb)
    } else {
        bw.write("NO")
    }
    br.close()
    bw.close()
}
