class Solution {
    fun solution(sides: IntArray) = if (sides[0] < sides[1]) {
        sides[0]*2 - 1
    } else {
        sides[1]*2 - 1
    }
}
