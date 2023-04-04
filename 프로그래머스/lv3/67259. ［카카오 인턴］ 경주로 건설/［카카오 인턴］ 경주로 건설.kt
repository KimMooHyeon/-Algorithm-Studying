import java.util.*

data class Point(val y:Int, val x:Int,val before :String ="start",val sum :Int=0)
data class PointCheck(val y:Int, val x:Int,val before :String)
class Solution {
    fun bfs(a:Point,board:Array<IntArray>,scoreMap:Array<IntArray>,hash:HashMap<PointCheck,Int>){
        val queue = LinkedList<Point>()
        val yOffset=arrayOf(0,0,1,-1)
        val xOffset=arrayOf(1,-1,0,0)
        
        queue.add(a)
        while(queue.isNotEmpty()){
            val nowPoint = queue.poll()
           // println(nowPoint)
            for (i in 0 .. 3){
                val curY = nowPoint.y +yOffset[i]
                val curX = nowPoint.x +xOffset[i]
                if(0<=curX && curX<board[0].size && 0<=curY && curY<board.size ){
                    if(board[curY][curX]!=1){
                        // 벽이 아님
                        when(i){
                            0->{
                                 //x+1
                                val checkPo = PointCheck(curY,curX,"right")
                                if(nowPoint.before == "start"){
                                    queue.add(Point(curY,curX,"right",100))
                                    scoreMap[curY][curX]=100
                                }else if(nowPoint.before == "right"){
                                   
                                    if(checkPo in hash){
                                       if(hash[checkPo]!! >=nowPoint.sum+100){
                                           hash[checkPo] = nowPoint.sum+100
                                           queue.add(Point(curY,curX,"right",nowPoint.sum+100))
                                       }
                                    }else{
                                        queue.add(Point(curY,curX,"right",nowPoint.sum+100))
                                        hash[checkPo] = nowPoint.sum+100
                                    }
                                   if(scoreMap[curY][curX]>=nowPoint.sum+100){
                                        scoreMap[curY][curX] = nowPoint.sum+100
                                     }
                                }else{
                                    if(checkPo in hash){
                                       if(hash[checkPo]!! >=nowPoint.sum+600){
                                           hash[checkPo] = nowPoint.sum+600
                                           queue.add(Point(curY,curX,"right",nowPoint.sum+600))
                                       }
                                    }else{
                                        queue.add(Point(curY,curX,"right",nowPoint.sum+600))
                                        hash[checkPo] = nowPoint.sum+600
                                    }
                                     if(scoreMap[curY][curX]>=nowPoint.sum+600){                             
                                         scoreMap[curY][curX] = nowPoint.sum+600
                                     }
                                }
                            }
                            1->{
                                //x-1
                                val checkPo = PointCheck(curY,curX,"left")
                                if(nowPoint.before == "start"){
                                    queue.add(Point(curY,curX,"left",100))
                                    scoreMap[curY][curX]=100
                                }else if(nowPoint.before == "left"){
                                   
                                    if(checkPo in hash){
                                       if(hash[checkPo]!! >=nowPoint.sum+100){
                                           hash[checkPo] = nowPoint.sum+100
                                           queue.add(Point(curY,curX,"left",nowPoint.sum+100))
                                       }
                                    }else{
                                        queue.add(Point(curY,curX,"left",nowPoint.sum+100))
                                        hash[checkPo] = nowPoint.sum+100
                                    }
                                   if(scoreMap[curY][curX]>=nowPoint.sum+100){
                                        scoreMap[curY][curX] = nowPoint.sum+100
                                     }
                                }else{
                                    if(checkPo in hash){
                                       if(hash[checkPo]!! >=nowPoint.sum+600){
                                           hash[checkPo] = nowPoint.sum+600
                                           queue.add(Point(curY,curX,"left",nowPoint.sum+600))
                                       }
                                    }else{
                                        queue.add(Point(curY,curX,"left",nowPoint.sum+600))
                                        hash[checkPo] = nowPoint.sum+600
                                    }
                                     if(scoreMap[curY][curX]>=nowPoint.sum+600){                             
                                         scoreMap[curY][curX] = nowPoint.sum+600
                                     }
                                }
                                
                            }
                            2->{
                                //y+1
                                val checkPo = PointCheck(curY,curX,"down")
                                if(nowPoint.before == "start"){
                                    queue.add(Point(curY,curX,"down",100))
                                    scoreMap[curY][curX]=100
                                }else if(nowPoint.before == "down"){
                            
                                    if(checkPo in hash){
                                       if(hash[checkPo]!! >=nowPoint.sum+100){
                                           hash[checkPo] = nowPoint.sum+100
                                           queue.add(Point(curY,curX,"down",nowPoint.sum+100))
                                       }
                                    }else{
                                        queue.add(Point(curY,curX,"down",nowPoint.sum+100))
                                        hash[checkPo] = nowPoint.sum+100
                                    }
                                   if(scoreMap[curY][curX]>=nowPoint.sum+100){
                                        scoreMap[curY][curX] = nowPoint.sum+100
                                     }
                                }else{
                                    if(checkPo in hash){
                                       if(hash[checkPo]!! >=nowPoint.sum+600){
                                           hash[checkPo] = nowPoint.sum+600
                                           queue.add(Point(curY,curX,"down",nowPoint.sum+600))
                                       }
                                    }else{
                                        queue.add(Point(curY,curX,"down",nowPoint.sum+600))
                                        hash[checkPo] = nowPoint.sum+600
                                    }
                                     if(scoreMap[curY][curX]>=nowPoint.sum+600){                             
                                         scoreMap[curY][curX] = nowPoint.sum+600
                                     }
                                }
                                
                            }
                            3->{
                                //y -1
                               val checkPo = PointCheck(curY,curX,"up")
                                if(nowPoint.before == "start"){
                                    queue.add(Point(curY,curX,"up",100))
                                    scoreMap[curY][curX]=100
                                }else if(nowPoint.before == "up"){
                            
                                    if(checkPo in hash){
                                       if(hash[checkPo]!! >=nowPoint.sum+100){
                                           hash[checkPo] = nowPoint.sum+100
                                           queue.add(Point(curY,curX,"up",nowPoint.sum+100))
                                       }
                                    }else{
                                        queue.add(Point(curY,curX,"up",nowPoint.sum+100))
                                        hash[checkPo] = nowPoint.sum+100
                                    }
                                   if(scoreMap[curY][curX]>=nowPoint.sum+100){
                                        scoreMap[curY][curX] = nowPoint.sum+100
                                     }
                                }else{
                                    if(checkPo in hash){
                                       if(hash[checkPo]!! >=nowPoint.sum+600){
                                           hash[checkPo] = nowPoint.sum+600
                                           queue.add(Point(curY,curX,"up",nowPoint.sum+600))
                                       }
                                    }else{
                                        queue.add(Point(curY,curX,"up",nowPoint.sum+600))
                                        hash[checkPo] = nowPoint.sum+600
                                    }
                                     if(scoreMap[curY][curX]>=nowPoint.sum+600){                             
                                         scoreMap[curY][curX] = nowPoint.sum+600
                                     }
                                }
                                
                            }
                            else->{}
                        }
                    }
                }
            }
        }
    }
    fun solution(board: Array<IntArray>): Int {
        var answer = 0
        var scoreMap =Array(board.size){IntArray(board[0].size){Integer.MAX_VALUE}}
        val hash =HashMap<PointCheck,Int>()
        scoreMap[0][0]=0
        bfs(Point(0,0,"start",0),board,scoreMap,hash)
        return scoreMap[board.size-1][board.size-1]
    }
}