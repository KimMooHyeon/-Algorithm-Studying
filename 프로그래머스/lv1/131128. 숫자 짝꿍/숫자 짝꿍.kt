import java.util.*

class Solution {
    fun solution(X: String, Y: String): String {
        var answer: String = ""
        var answerList = mutableListOf<Char>()
        var xList = X.toMutableList()
        var yList = Y.toMutableList()
        var xIndex=0
        var yIndex=0
        xList.sortDescending()
        yList.sortDescending()
        
        while(xList.isNotEmpty() && yList.isNotEmpty() ){
            if(xIndex>=xList.size || yIndex>= yList.size){
                break
            }
            if(xList[xIndex]==yList[yIndex]){
              answerList.add(xList[xIndex])
              xIndex+=1
              yIndex+=1
            }else if(xList[xIndex]>yList[yIndex]){
               xIndex+=1
            }else{
               yIndex+=1
            }
        }
        if(answerList.isEmpty()){
            answer="-1"
        }else{
            if(answerList.size>1 && answerList[0]=='0'){
                answer="0"
            }else{
                 answer=answerList.joinToString("")   
            }
        }
        return answer
    }
}