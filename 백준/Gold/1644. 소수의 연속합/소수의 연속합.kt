import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun isPrime(n: Long): Boolean {
    var i: Long = 2
    while (i * i <= n) {
        if (n % i++ == 0L) {
            return false
        }
    }
    return true
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
// 2 3 5 7 11 13
    val nList = mutableListOf<Int>(2, 3)
    var num = 4
    var beforePrime = 4
    if (n == 2 || n == 3) {
        println(1)
    }else if(n ==1){
        println(0)
    }
    else {
        while (true) {
            if (isPrime(num.toLong())) {
                if (beforePrime + num > n) {
                    break
                } else {
                    nList.add(num)
                    beforePrime = num
                }
            } else {
                //소수가 아님
            }
            num += 1
        }
        //    println(nList)
        var answer = 0
        var left = 0
        var right = 1
        val maxSize = nList.size
        if (maxSize < 2) {
            println(0)
        } else {
            if (isPrime(n.toLong())) {
                answer += 1
            }
            var sum = nList[left] + nList[right]
            while (right < maxSize && left < right) {
                if (sum == n) {
                    answer += 1
                    sum -= nList[left]
                    left += 1
                    right += 1
                    if (right >= maxSize) {
                        break
                    }
                    sum += nList[right]
                } else if (sum < n) {
                    right += 1
                    if (right >= maxSize) {
                        break
                    }
                    sum += nList[right]
                } else {
                    sum -= nList[left]
                    left += 1
                }
            }
            println(answer)
        }
    }

    bw.close()
    br.close()
}
