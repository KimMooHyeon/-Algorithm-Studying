import java.util.*

data class Point(val y : Int, val x : Int, val cost:Int)

class Solution {
    fun bfs(grid: Array<IntArray>, mapCost : Array<IntArray>){
        val xOffset=listOf(0,0,1,-1,1,-1,1,-1)
        val yOffset=listOf(1,-1,0,0,1,-1,-1,1)
        val xSize = grid[0].size
        val ySize = grid.size
        
        val queue =LinkedList<Point>()
        queue.add(Point(0,0,1))
        
        while(queue.isNotEmpty()){
            val curPoint = queue.poll()
            for(i in 0 .. 7){
                val nextX=curPoint.x +xOffset[i]
                val nextY=curPoint.y +yOffset[i]
                if(0<= nextX && nextX<xSize && 0<= nextY && nextY<ySize){
                    if(grid[nextY][nextX] == 0){
                        val nextCost = curPoint.cost+1
                        if(mapCost[nextY][nextX]>nextCost){
                            mapCost[nextY][nextX]=nextCost
                            queue.add(Point(nextY,nextX,nextCost))
                        }
                    }
                }
            }
            
        }
    }
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        var answer = 0
        val mapCost = Array(grid.size){IntArray(grid[0].size){Int.MAX_VALUE}}
        mapCost[0][0] = 1
        bfs(grid,mapCost)
        if(grid[0][0]==1){
            return -1
        }
        if(mapCost[grid.size-1][grid[0].size-1] == Int.MAX_VALUE){
            answer=-1
        }else{
            answer = mapCost[grid.size-1][grid[0].size-1]
        }
    
        return answer
    }
}