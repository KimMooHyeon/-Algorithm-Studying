import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
//모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
//같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
fun check(text: String): Boolean {
    var aeiu = 0
    var consonant = 0
    var vowel = 0
    var before = ' '
    for (i in 0 until text.length) {
        if (text[i] == 'a' || text[i] == 'e' || text[i] == 'i' || text[i] == 'o' || text[i] == 'u') {
            consonant += 1
            vowel = 0
            aeiu += 1
        } else {
            consonant = 0
            vowel += 1
        }
        if (text[i] != 'e' && text[i] != 'o') {
            if (text[i] == before) {
                return false
            }
        }
        before = text[i]
        if (consonant >= 3 || vowel >= 3) {
            return false
        }

    }
    if (aeiu <= 0) {
        return false
    }
    return true
}

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    /*val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val temp = br.readLine().split(" ").map { it.toInt() }*/
    while (true) {
        val text = br.readLine()

        if (text == "end") {
            break
        }

        if (check(text)) {
            println("<${text}> is acceptable.")
        } else {
            println("<${text}> is not acceptable.")
        }
    }

    br.close()
    bw.close()
}
