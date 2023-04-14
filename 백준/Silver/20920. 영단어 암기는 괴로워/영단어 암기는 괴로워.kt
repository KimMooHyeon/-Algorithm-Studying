import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

//자주 나오는 단어일수록 앞에 배치한다.
//해당 단어의 길이가 길수록 앞에 배치한다.
//알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
data class Word(val name: String, val num: Int) : Comparable<Word> {
    override fun compareTo(other: Word): Int {
        if (other.num - num > 0) {
            return 1
        } else if (other.num - num < 0) {
            return -1
        } else {
            if (other.name.length - name.length > 0) {
                return 1
            } else if (other.name.length - name.length < 0) {
                return -1
            } else {
                if (other.name < name) {
                    return 1
                } else {
                    return -1
                }

            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val hash = HashMap<String, Int>()
    val englishList = PriorityQueue<Word>()
    repeat(n) {
        val word = br.readLine().toString()
        if (word.length >= m) {
            if (word in hash) {
                hash[word] = hash[word]!! + 1
            } else {
                hash[word] = 1
            }
        }
    }
    hash.forEach {
        englishList.add(Word(it.key, it.value))
    }
    while (englishList.isNotEmpty()){
        bw.write("${englishList.poll().name}\n")
    }

    br.close()
    bw.close()
}