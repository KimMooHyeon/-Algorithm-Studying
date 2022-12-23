class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
  
        var checkNum = ""
        for(i in 0 until t.length){
            if(checkNum.length<p.length){
                checkNum+=t[i].toString()
               if(checkNum.length==p.length){
                 if(checkNum<=p){
                    answer+=1
                  }
                }
            }else{
                checkNum=checkNum.substring(1,checkNum.length)
                checkNum+=t[i].toString()
                if(checkNum<=p){
                    answer+=1
                }
            }
        }
        return answer
    }
}