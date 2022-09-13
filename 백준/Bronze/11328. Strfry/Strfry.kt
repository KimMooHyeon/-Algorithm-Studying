import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    for (i in 1..br.readLine().toInt()) {
        val (a, b) = br.readLine().split(" ")
        val bList = b.split("").toMutableList()

        for (i in a.split("")) {
            if (bList.contains(i)) {
                bList.remove(i)
            }
        }
        if (bList.isEmpty() && a.length == b.length) {
            println("Possible")
        } else {
            println("Impossible")
        }
    }

}
