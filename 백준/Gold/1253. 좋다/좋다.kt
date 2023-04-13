import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var answer = 0
    val n = br.readLine().toInt()
    val hash = HashMap<Int, Int>()

    val A = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    //사이즈가 3보다 작으면 무조건 만들수 없음
    if (n < 3) {
        println(0)
        return
    }

    for (i in 0 until n) {
        if (A[i] !in hash) {
            hash[A[i]] = 1
        } else {
            hash[A[i]] = hash[A[i]]!! + 1
        }
    }

    for (i in 0 until n) {
        for (j in n - 1 downTo 0) {
            if (i != j) {
                hash[A[i]] = hash[A[i]]!! - 1
                hash[A[j]] = hash[A[j]]!! - 1
                if (A[i] - A[j] in hash) {
                    if (hash[A[i] - A[j]]!! > 0) {
                        answer += 1
                        hash[A[i]] = hash[A[i]]!! + 1
                        hash[A[j]] = hash[A[j]]!! + 1
                        break
                    }
                }
                hash[A[i]] = hash[A[i]]!! + 1
                hash[A[j]] = hash[A[j]]!! + 1
            }
        }
    }

    println(answer)

    br.close()
    bw.close()
}
