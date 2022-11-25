class Solution {
    lateinit var bombMap : Array<BooleanArray>
    val xOffset = listOf(-1,-1,-1,0,0,0,1,1,1)
    val yOffset = listOf(-1,0,1,-1,0,1,-1,0,1)
    var ySize = 0
    var xSize = 0
    fun solution(board: Array<IntArray>): Int {
        var answer: Int = 0
         ySize = board.size
         xSize = board[0].size
        bombMap = Array(board.size){BooleanArray(board[0].size){true}}
        board.forEachIndexed{ y,v->
            v.forEachIndexed{ x, va->
                if(va == 1){
                    bomb(y,x)
                }
            }
        }
         bombMap.forEachIndexed{ y,v->
            v.forEachIndexed{ x, va->
              if(va){
                  answer+=1
              }
            }
            println()
        }
        return answer
    }
    fun bomb(y:Int, x:Int){
         var newX = x
         var newY = y
        for(i in 0 .. 8){
             newX = x+ xOffset[i]
             newY = y+ yOffset[i]
            if(newY>=0 && newX>=0 && ySize>newY && xSize >newX){
                bombMap[newY][newX]=false
            }
        }
    }
}