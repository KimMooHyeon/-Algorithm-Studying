import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*
import kotlin.math.min

var checkList = mutableSetOf<kotlin.collections.List<String>>()
var size = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var maxNum = -100000000
    var minNum = 100000000
    val n = br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toInt() }

    size = nList.size - 1
    // 덧셈, 뺄셈, 곱셈, 나눗셈의 개수
    val operatorNumList = br.readLine().split(" ").map { it.toInt() }
    val operatorList = mutableListOf<String>()
    operatorNumList.forEachIndexed { index, i ->
        when (index) {
            0 -> {
                for (i in 0 until operatorNumList[index]) {
                    operatorList.add("+")
                }

            }
            1 -> {
                for (i in 0 until operatorNumList[index]) {
                    operatorList.add("-")
                }
            }
            2 -> {
                for (i in 0 until operatorNumList[index]) {
                    operatorList.add("*")
                }
            }
            3 -> {
                for (i in 0 until operatorNumList[index]) {
                    operatorList.add("/")
                }
            }
        }
    }
    permutation(operatorList, BooleanArray(operatorList.size) { false }, 0, mutableListOf())
    checkList.forEachIndexed { index, strings ->
        val sum = cal(nList.toMutableList(), strings)
        maxNum = max(maxNum, sum)
        minNum = min(minNum, sum)
    }
    println(maxNum)
    println(minNum)
}

fun cal(numList: MutableList<Int>, checkList: kotlin.collections.List<String>): Int {
    val nQueue= LinkedList<Int>()
    nQueue.addAll(numList)

    for (i in 0 until checkList.size) {

        val start = nQueue.poll()
        val second = nQueue.poll()
        when (checkList[i]) {
            "+" -> {

                nQueue.addFirst(start + second)
            }
            "-" -> {
                nQueue.addFirst(start - second)
            }
            "*" -> {
                nQueue.addFirst(start * second)
            }
            "/" -> {
                nQueue.addFirst(start / second)
            }
        }
    }
    return nQueue.poll()
}

fun permutation(operatorList: MutableList<String>, visited: BooleanArray, index: Int, choice: MutableList<String>) {
  
    if (choice.size == size) {
            checkList.add(choice.map { it })
        return
    }
    if (index - 1 >= operatorList.size) {
        return
    }
    val temp = choice.map { it }.toMutableList()
    for (i in 0 until operatorList.size) {
        if (!visited[i]) {
            visited[i] = true
            temp.add(operatorList[i])
            permutation(operatorList, visited.map { it }.toBooleanArray(), i + 1, temp)
            temp.removeAt(temp.size - 1)
            visited[i] = false
        }

    }
}



