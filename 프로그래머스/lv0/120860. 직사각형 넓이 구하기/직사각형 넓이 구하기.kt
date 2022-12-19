class Solution {
    fun solution(dots: Array<IntArray>): Int {
        var answer: Int = 0
        dots.sortWith(compareBy({it[0]}))
        return (dots[3][0]-dots[0][0])*(dots[1][1]-dots[0][1])
    }
}