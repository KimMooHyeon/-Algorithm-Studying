import java.util.*
class Solution {
    fun solution(numbers: IntArray, k: Int): Int {
        var answer: Int = 0
        var numbersList =LinkedList<Int>()
        numbers.forEach{
            numbersList.add(it)
        }
        for(i in 1 until k){    
            numbersList.add(numbersList.poll())
            numbersList.add(numbersList.poll())
          //  println(numbersList)
        }
        return numbersList.poll()
    }
}