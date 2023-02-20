import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val m = br.readLine().toInt()
    val mList = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    nList.sortDescending()
    mList.sortDescending()
    var answer = 0
    if (mList[0] > nList[0]) {
        println(-1)
    } else {
        while (mList.isNotEmpty()) {
            answer += 1
            for (i in 0 until nList.size) {
                for (j in 0 until mList.size) {
                    if (nList[i] >= mList[j]) {
                        mList.removeAt(j)
                        break
                    }
                }
            }
        }
        println(answer)
    }
    br.close()
}