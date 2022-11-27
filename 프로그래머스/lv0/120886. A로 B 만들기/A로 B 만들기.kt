class Solution {
    fun solution(before: String, after: String): Int {
        var answer: Int = 0
      
        return if(before.toList().sorted()==after.toList().sorted()){
            1
        }else{
            0
        }
    }
}