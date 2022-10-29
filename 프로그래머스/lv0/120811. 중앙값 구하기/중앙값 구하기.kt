class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        array.sort()
        return array[array.size/2]
    }
}