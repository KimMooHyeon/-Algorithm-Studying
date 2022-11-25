class Solution {
    fun solution(n: Int, numlist: IntArray): List<Int> {
        return numlist.filter{
                       it%n==0
                   }
      
    }
}