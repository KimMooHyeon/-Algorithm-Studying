class Solution {
    fun solution(num_list: IntArray): IntArray {
        var even=0
        var odd=0
        num_list.forEach{
            if(it%2==0){
                even+=1
            }else{
                odd+=1
            }
        }
        return intArrayOf(even,odd)
    }
}