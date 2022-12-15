class Solution {
    fun solution(common: IntArray): Int {
        var answer: Int = 0
        if(common[1]-common[0] == common[2]-common[1] ){
            return common[common.size-1]+(common[2]-common[1])
        }else{
            return common[common.size-1]*(common[common.size-1]/common[common.size-2])
        }
        return answer
    }
}