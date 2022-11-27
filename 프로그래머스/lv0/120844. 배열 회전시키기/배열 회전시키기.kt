import java.util.*
class Solution {
    fun solution(numbers: IntArray, direction: String): IntArray {
        var answer: IntArray = intArrayOf()
        val ll = LinkedList<Int>()
        numbers.forEach{
            ll.add(it)
        }
        if(direction=="left"){
            ll.add(ll.poll())
        }else{
            ll.addFirst(ll.removeLast())
        }
        return ll.toIntArray()
    }
}