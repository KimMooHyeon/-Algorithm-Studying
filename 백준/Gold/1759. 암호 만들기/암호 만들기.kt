import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 암호는 서로 다른 L개의 알파벳 소문자들로 구성
// 최소 한개의 모음(a,e,i,o,u) 과 최소 두개의 자음
// 정렬이 된 암호만 가능성이 있다.
// 암호로 사용했을만한 문자는 C가지
// 모든 암호를 구하시오
var answer = mutableListOf<String>()

fun isRight(nowKey: String, L: Int): Boolean {
    val moNum = nowKey.filter { it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' }
    return if (moNum.isEmpty()) {
        false
    } else {
        L - moNum.length >= 2
    }
}

fun sol(startIndex:Int,alpha: List<String>, checkUsing: BooleanArray, nowKey: String, selectKey: Int, L: Int) {
    if (selectKey == L) {
        if (isRight(nowKey, L)) {
            answer.add(nowKey)
        }
        return
    }
    for (i in startIndex..alpha.lastIndex) {
        if (checkUsing[i]) {
            checkUsing[i] = false
            sol(i+1,alpha, checkUsing, nowKey + alpha[i], selectKey + 1, L)
            checkUsing[i] = true
        }
    }

}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // 암호는 L 사이즈
    // 3 ≤ L ≤ C ≤ 15
    val (L, C) = br.readLine().split(" ").map { it.toInt() }
    val checkUsing = BooleanArray(C) { true }
    val alpha = br.readLine().split(" ").map { it.toString() }.toMutableList()
    alpha.sort()
    sol(0,alpha,checkUsing,"",0,L)
    answer.forEach {
        println(it)
    }

    br.close()
    bw.close()
}