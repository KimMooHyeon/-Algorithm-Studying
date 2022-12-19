class Solution {
        var xPoint = 0
        var yPoint = 0
    fun solution(keyinput: Array<String>, board: IntArray): IntArray {
        var answer: IntArray = IntArray(2)

        keyinput.forEach{
            when(it){
                "left"->{
                    xPoint-=1
                }
                  "right"->{
                    xPoint+=1
                }
                    "up"->{
                    yPoint+=1
                }
                     "down"->{
                    yPoint-=1
                }
            }
            checkMapSize(board)
        }
    
        answer[0]=xPoint
        answer[1]=yPoint
        return answer
    }
    fun checkMapSize(board: IntArray){
        if(xPoint>=board[0]/2){
            xPoint=board[0]/2
        }
        if(xPoint<= -(board[0]/2)){
            xPoint=-(board[0]/2)
        }
        if(yPoint>=board[1]/2){
            yPoint=board[1]/2
        }
        if(yPoint<= -(board[1]/2)){
            yPoint=-(board[1]/2)
        }
    }
}