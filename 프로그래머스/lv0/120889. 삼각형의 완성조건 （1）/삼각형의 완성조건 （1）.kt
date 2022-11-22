class Solution {
    fun solution(sides: IntArray): Int {
        var answer: Int = 0
        sides.sortDescending()
        if(sides[0]>=sides[1]+sides[2]){
            return 2
        }else{
            return 1
        }
    }
}