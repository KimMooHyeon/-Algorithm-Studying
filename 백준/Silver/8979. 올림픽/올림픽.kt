import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

data class Country(val index: Int, val g: Int, val s: Int, val b: Int) : Comparable<Country> {
    override fun compareTo(other: Country): Int {
        return if (g != other.g) {
            other.g - g
        } else if (s != other.s) {
            other.s - s
        } else if (b != other.b) {
            other.b - b
        } else {
            0
        }
    }
}

//금메달 수가 더 많은 나라
//금메달 수가 같으면, 은메달 수가 더 많은 나라
//금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val countryArray = IntArray(n)
    val countryQueue = PriorityQueue<Country>()
    val hash = HashMap<Int, Boolean>()
    repeat(n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        countryQueue.add(Country(temp[0], temp[1], temp[2], temp[3]))
        hash[temp[0]] = true
    }

    while (countryQueue.isNotEmpty()) {
        var temp = countryQueue.poll()
        var num = 0
        if (countryQueue.isNotEmpty()) {
            if (temp.compareTo(countryQueue.peek()) == 0) {
                countryArray[temp.index - 1] += 1
                hash[temp.index] = false
                while (countryQueue.isNotEmpty()) {
                    if (temp.compareTo(countryQueue.peek()) !=0){
                        break
                    }
                    num+=1
                    temp = countryQueue.poll()
                    countryArray[temp.index - 1] += 1
                    hash[temp.index] = false
                }
            }else {
                countryArray[temp.index - 1] += 1
                hash[temp.index] = false
            }
        } else {
            countryArray[temp.index - 1] += 1
            hash[temp.index] = false
        }

        for (i in 0 until n) {
            if (hash[i + 1]!!) {
                countryArray[i] += 1 + num
            }
        }
    }

    println(countryArray[k - 1])

    br.close()
    bw.close()
}
