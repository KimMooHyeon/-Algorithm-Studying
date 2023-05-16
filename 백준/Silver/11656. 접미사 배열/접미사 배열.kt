import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toString()
    val stringList = mutableListOf<String>()
    var num =n.length-1
    var addString = ""
    while (true){
        addString = n[num]+addString
        stringList.add(addString)
        num-=1
        if (num<0){
            break
        }
    }
    stringList.sort()
    stringList.forEach {
        bw.write("$it\n")
    }
    bw.close()
}

