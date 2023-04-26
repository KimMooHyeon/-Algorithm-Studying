import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val T = br.readLine().toInt()
    val n = br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toLong() }
    val m = br.readLine().toInt()
    val mList = br.readLine().split(" ").map { it.toLong() }

    val nMap = Array(nList.size) { LongArray(nList.size) }
    val mMap = Array(mList.size) { LongArray(mList.size) }

    val nHash = HashMap<Long, Long>()
    val mHash = HashMap<Long, Long>()

    for (i in 0..nList.lastIndex) {
        for (j in i..nList.lastIndex) {
            if (i == j) {
                nMap[i][j] = nList[i]
            } else {
                nMap[i][j] = nMap[i][j - 1] + nList[j]
            }
            if (nMap[i][j] in nHash) {
                nHash[nMap[i][j]] = nHash[nMap[i][j]]!! + 1
            } else {
                nHash[nMap[i][j]] = 1
            }
        }
    }
    for (i in 0..mList.lastIndex) {
        for (j in i..mList.lastIndex) {
            if (i == j) {
                mMap[i][j] = mList[i]
            } else {
                mMap[i][j] = mMap[i][j - 1] + mList[j]
            }
            if (mMap[i][j] in mHash) {
                mHash[mMap[i][j]] = mHash[mMap[i][j]]!! + 1
            } else {
                mHash[mMap[i][j]] = 1
            }
        }
    }
    var answer: Long = 0
    mHash.forEach {
        if (T - it.key in nHash) {
            answer += (it.value * nHash[T - it.key]!!)
        }
    }
/*
    nHash.forEach {
        println(it)
    }
    println()
    mHash.forEach {
        println(it)
    }
*/

    println(answer)

    br.close()
    bw.close()
}
