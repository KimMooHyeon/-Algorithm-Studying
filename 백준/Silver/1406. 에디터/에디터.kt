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
    val N = br.readLine()
    val nList = LinkedList<String>()
    N.map { nList.add(it.toString()) }

    val M = br.readLine().toInt()
    var index = nList.listIterator()
    while (index.hasNext()) index.next()
    for (i in 0 until M){
        val input = br.readLine().split(" ")
        when(input[0]){
            "L"->{
                if (index.hasPrevious()){
                    index.previous()
                }
            }
            "D"->{
                if (index.hasNext()){
                    index.next()
                }
            }
            "B"->{
                if (index.hasPrevious()){
                    index.previous()
                    index.remove()
                }
            }
            "P"->{
                index.add(input[1])
            }
        }
    }

    bw.write(nList.joinToString(""))
    br.close()
    bw.close()
}
