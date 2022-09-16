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
    val ll = LinkedList<Int>()

    for (i in 0 until br.readLine().toInt()) {
        val control = br.readLine().split(" ")
        when (control[0]) {
            "push_front" -> {
                ll.addFirst(control[1].toInt())
            }
            "push_back" -> {
                ll.addLast(control[1].toInt())
            }
            "pop_front" -> {
                if (ll.size == 0) {
                    bw.write("-1\n")
                } else {
                    bw.write("${ll.pollFirst()}\n")
                }
            }
            "pop_back" -> {
                if (ll.size == 0) {
                    bw.write("-1\n")
                } else {
                    bw.write("${ll.pollLast()}\n")
                }
            }
            "size" -> {
                bw.write("${ll.size}\n")
            }
            "empty" -> {
                if (ll.size == 0) {
                    bw.write("1\n")
                } else {
                    bw.write("0\n")
                }
            }
            "front" -> {
                if (ll.size == 0) {
                    bw.write("-1\n")
                } else {
                    bw.write("${ll.peekFirst()}\n")
                }
            }
            "back" -> {
                if (ll.size == 0) {
                    bw.write("-1\n")
                } else {
                    bw.write("${ll.peekLast()}\n")
                }
            }
        }
    }
    br.close()
    bw.close()
}
