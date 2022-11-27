import kotlin.math.*
class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0
        numbers.sort()
        return max(numbers[numbers.size-1]*numbers[numbers.size-2],numbers[0]*numbers[1])
    }
}