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

    val T = br.readLine().toInt()

    for (t in 0 until T) {
        val p = br.readLine().replace("RR","").map { it }
        val n = br.readLine().toInt()
        val tmp = br.readLine()
        val dq = ArrayDeque<Int>()
        var res = true
        if (tmp != "[]") {
            tmp.substring(1, tmp.length - 1).split(",").map {
                dq.add(it.toInt())
            }
        }

        if ( p.count { it=='D' }>n) {
            bw.write("error\n")
            continue
        }
        var reverseFlag=true
        for (it in p) {
            when (it) {
                'R' -> {
                    reverseFlag = !reverseFlag
                }
                'D' -> {
                    if (dq.isEmpty()) {
                        res = false
                        break
                    } else {
                        if (reverseFlag){
                            dq.removeFirst()
                        }else{
                            dq.removeLast()
                        }
                    }
                }
                else -> {
                    res = false
                    break
                }
            }
        }
        if (!reverseFlag){
            dq.reverse()
        }
        if (res) {
            bw.write("${dq.joinToString(",","[","]")}\n")
        } else {
            bw.write("error\n")
        }

    }

    br.close()
    bw.close()
}
