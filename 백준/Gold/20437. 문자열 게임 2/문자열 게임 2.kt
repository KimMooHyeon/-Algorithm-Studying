import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val resultList = mutableListOf<String>()
    repeat(n) {
        val w = br.readLine()
        val k = br.readLine().toInt()
        val hash = HashMap<Char, MutableList<Int>>()
        if (k == 1) {
            resultList.add("1 1")
        } else {
            w.forEachIndexed { index, v ->
                if (v in hash) {
                    hash[v]!!.add(index)
                } else {
                    hash[v] = mutableListOf(index)
                }
            }
            val result = hash.filter { it.value.size >= k }

            if (result.isEmpty()) {
                resultList.add("-1")
            } else {
                // 0 1 2 3 4 5
                var minNum = 10000
                var maxNum = 1
                result.forEach {
                    for (i in 0 until it.value.lastIndex) {
                        if (i + k - 1 > it.value.lastIndex) {
                            break
                        }
                        if (it.value[i + k - 1] - it.value[i] + 1 > maxNum) {
                            maxNum = it.value[i + k - 1] - it.value[i] + 1
                        }
                        if (it.value[i + k - 1] - it.value[i] + 1 < minNum) {
                            minNum = it.value[i + k - 1] - it.value[i] + 1
                        }
                    }
                }
                resultList.add("$minNum $maxNum")
            }
        }


    }

    resultList.forEach {
        bw.write("${it}\n")
    }

    bw.close()
    br.close()
}
