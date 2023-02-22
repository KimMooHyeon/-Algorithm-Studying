import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val s = br.readLine().toString().toInt()
    print(check(s, nList).joinToString(" "))
    br.close()
}

fun check(_s: Int, nList: MutableList<Int>): MutableList<Int> {
    var s = _s

    for (i in 0 until nList.size - 1) {
        val maxNum = if (s > nList.size) {
            findMaxNum(i, nList.size, nList)
        } else {
            findMaxNum(i, s + 1, nList)
        }

        s -= (nList.indexOf(maxNum) - i)
        nList.remove(maxNum)
        nList.add(i, maxNum)
    }

    return nList
}

fun findMaxNum(index: Int, s: Int, nList: MutableList<Int>): Int {
    return if (index + s > nList.size) {
        nList.subList(index, nList.size).maxOrNull()!!
    } else {
        nList.subList(index, index + s).maxOrNull()!!
    }
}