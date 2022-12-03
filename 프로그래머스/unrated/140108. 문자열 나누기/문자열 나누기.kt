class Solution {
    var index = 0
    var answer: Int = 0
    fun solution(s: String): Int {
        while(index<s.length){
            splitString(s)
        }
        return answer
    }
    fun splitString(s:String){
        val startX = s[index]
        var sameCount = 1
        var differentCount =0
       
        while(sameCount != differentCount){
            index+=1
             if(index>=s.length){
                 break
             }
            if(s[index]==startX){
                sameCount+=1
            }else{
                differentCount+=1
            }
        }
        index+=1
        answer+=1
    }
}