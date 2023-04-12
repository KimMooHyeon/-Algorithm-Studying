import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashMap

//같은 키를 가진 학생은 한 명도 없다
//1. 우선 아무나 한 명을 뽑아 줄의 맨 앞에 세운다.
//2.  그 다음부터는 학생이 한 명씩 줄의 맨 뒤에 서면서 다음 과정을 거친다.

//자기 앞에 자기보다 키가 큰 학생이 없다면 그냥 그 자리에 서고 차례가 끝난다.
//자기 앞에 자기보다 키가 큰 학생이 한 명 이상 있다면 그중 가장 앞에 있는 학생(A)의 바로 앞에 선다.
//이때, A부터 그 뒤의 모든 학생들은 공간을 만들기 위해 한 발씩 뒤로 물러서게 된다.
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var tc = br.readLine().toInt()
    var answerList = Array(tc) { IntArray(2) }
    repeat(tc) { tcNum ->
        var switchNum = 0
        val temp = br.readLine().split(" ").map { it.toInt() }
        val hash = HashMap<Int, Int>()
        repeat(20) {
            hash[it + 1] = -1
        }
        var tail = 1
        hash[1] = temp[1]
        repeat(19) {
            tail += 1
            val height = temp[it + 2]
            hash[tail] = height
       /*     repeat(20){
                if (hash[it+1] != 0) {
                    print("${hash[it+1]} ")
                }
            }
            println()*/
            if (hash[tail - 1]!! < height) {
                //줄 세대로 섰음
            } else {
                for (i in 1 until tail) {
                    if (hash[i]!! > height) {
                        for (j in tail downTo i + 1) {
                            hash[j] = hash[j - 1]!!
                            switchNum += 1
                        }
                        hash[i] = height
                        break
                    }
                }
            }
        }
        answerList[tcNum][0] = tcNum + 1
        answerList[tcNum][1] = switchNum
    }
    answerList.forEach {
        println("${it[0]} ${it[1]}")
    }
    br.close()
    bw.close()
}
