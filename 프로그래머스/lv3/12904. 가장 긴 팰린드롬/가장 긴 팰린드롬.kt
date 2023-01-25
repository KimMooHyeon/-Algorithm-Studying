class Solution {
    fun solution(s: String): Int {
        if(s.length == 0){
            return 0
        }
        if(s.length<2){
            return s.length
        }
        var answer = 1
    for(len in s.length downTo 2){
        for(start in 0 ..  s.length -len){
            var flag = true
            var num = 0
           for(k in start until len+start){
          //     println("${k} ${len+start-1-num}")
    
                 if(s[k] != s[len+start-1-num]){
                     flag = false
                   //  println("컷")
                     break
                }
                  num+=1
           }
           //println()
           if(flag){
               return len
           }
        }
    }

        return answer
    }
}