import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun toLong(s: String): Long {
    return s.toLong()
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st: StringTokenizer = StringTokenizer(br.readLine())
    val n: Long = toLong(st.nextToken())
    val k: Long = toLong(st.nextToken())
    val _num = mutableListOf<Long>()
    st = StringTokenizer(br.readLine())

    val queue = PriorityQueue<Long>()
    for (i in 0 until n) {
        _num.add(toLong(st.nextToken()))
    }

    repeat(k.toInt()) {
        queue.add(_num[it])
    }
    repeat((n - k).toInt()) {
        queue.add(_num[(it + k).toInt()])
        _num[it] = queue.peek()
        queue.poll()
    }
    repeat((n-k).toInt()){
        print("${_num[it]} ")
    }
    while (queue.isNotEmpty()){
        print("${queue.poll()} ")
    }
    br.close()
    bw.close()
}

