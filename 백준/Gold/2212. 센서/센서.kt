import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    // n개의 센서가 하나의 집중국과 통신이 가능해야함
    // 집중국의 유지비 문제로 각 집중국의 수신 가능 영역의 길이의 합을 최소화
    val n = br.readLine().toInt()
    // k개의 집중국
    val k = br.readLine().toInt()
    val _temp = br.readLine().split(" ").map { it.toInt() }
    val temp = _temp.sorted()

    if (n<=k){
        println(0)
    }else{
        val numArray = IntArray(temp.size)
        for (i in 0 until temp.lastIndex) {
            numArray[i] = temp[i + 1] - temp[i]
        }

        println(numArray.sortedBy { -it }.subList(k-1,numArray.size).sum())
    }

    bw.close()
}

