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
    val N = br.readLine().toInt()
    val nList = br.readLine().split(" ")
    val M = br.readLine().toInt()
    val mList = br.readLine().split(" ")
    val hs = HashMap<Int,Int>()
    mList.map {
        hs[it.toInt()]=0
    }
    nList.map {
        if (hs.containsKey(it.toInt())){
            hs[it.toInt()] = hs[it.toInt()]!!+1
        }
    }

    mList.map { mItem->
        bw.write("${hs[mItem.toInt()]} ")
    }

    br.close()
    bw.close()
}
