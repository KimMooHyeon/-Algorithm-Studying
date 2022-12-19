class Solution {
    fun solution(polynomial: String): String {
        var answer: String = ""
        var xSize = 0
        var numberSize=  0
        var temp = polynomial.split(" + ").map{it.toString()}
        temp.forEach{
           if("x" in it){
               if(it == "x"){
                   xSize+=1
               }else{
                   xSize+=(it.substring(0,it.length-1)).toInt()
               }
           }else{
               numberSize+=it.toInt()
           }
        }
        if(xSize!=0&&numberSize!=0){
            if(xSize == 1){
                 answer="x + $numberSize"
            }else{
                 answer="${xSize}x + $numberSize"
            }
        }else if(xSize!=0){
          
            if(xSize == 1){
                answer="x"
            }else{
                answer="${xSize}x"
            }
        }else if(numberSize!=0){
            answer="$numberSize"
        }
        return answer
    }
}