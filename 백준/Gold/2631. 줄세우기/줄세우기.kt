import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

var n = 0
var maxNum = 1
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    val first = IntArray(n + 1) { it }
    repeat(n) {
        val num = br.readLine().toInt()
        first[it + 1] = num
    }

    for (i in 1 until n) {
        if (first[i] < first[i + 1]) {
            findNum(i, i + 1, first[i + 1], 1, first)
        }
        findNum(i, i + 1, first[i], 1, first)

    }
    println(n - maxNum)
}

var hash = HashMap<Pair<Int, Int>, Int>()
fun findNum(startIndex: Int, nextIndex: Int, max: Int, count: Int, first: IntArray) {
    // 3 7
    val temp = Pair(startIndex,max)
    if (temp !in hash){
        hash[temp]=count
    }else{
        if (hash[temp]!!>count){
            return
        }else{
            hash[temp]=count
        }
    }
    if (n == nextIndex) {
        if (first[nextIndex] > max) {
            maxNum = max(count + 1, maxNum)
        } else {
            maxNum = max(count, maxNum)
        }
        return
    }
    if (first[nextIndex] >= max) {
        findNum(nextIndex, nextIndex + 1, first[nextIndex], count + 1, first)
    }
    findNum(nextIndex, nextIndex + 1, max, count, first)

    return
}

