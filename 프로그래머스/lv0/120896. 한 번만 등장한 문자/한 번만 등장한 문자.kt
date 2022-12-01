class Solution {
    fun solution(s: String): String {
        var answer: String = ""
        var hs = HashMap<String,Int>()
        var temp =s.toList().map{it.toString()}.sorted()
  
       
        var before=""
        temp.forEach{
            if(hs.containsKey(it.toString())){
                hs[it.toString()] = hs[it.toString()]!! + 1
            }else{
                 hs[it.toString()] =1
            }
        }
         temp.forEach{
           if(hs[it.toString()]!! ==1){
               answer+=it.toString()
           }
        }
         return answer
    }
}