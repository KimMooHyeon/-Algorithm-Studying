class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0
        numbers.sortDescending()
        
        return numbers[0]*numbers[1]
    }
}