import java.util.*

data class Point(val y:Int, val x:Int)

class Solution {
    fun bfs(grid: Array<CharArray>, mapBoolean : Array<BooleanArray>,start:Point){
        val queue = LinkedList<Point>()
        queue.add(start)
        val xOffset = listOf(0,0,1,-1)
        val yOffset = listOf(1,-1,0,0)
        val xSize = grid[0].size
        val ySize = grid.size
        
        while(queue.isNotEmpty()){
            val curPoint = queue.poll()
            mapBoolean[curPoint.y][curPoint.x] = false
            for(i in 0 ..3){
                val nextX= curPoint.x + xOffset[i]
                val nextY= curPoint.y + yOffset[i]
                if(0<=nextX && nextX<xSize && 0<=nextY && nextY<ySize){
                    if(mapBoolean[nextY][nextX]){
                        mapBoolean[nextY][nextX] = false
                        queue.add(Point(nextY,nextX))
                    }
                }
            }
        }
    }
    fun numIslands(grid: Array<CharArray>): Int {
        var answer = 0
        var mapBoolean = Array(grid.size){BooleanArray(grid[0].size){false}}
        for(i in 0 until grid.size){
            for(j in 0 until grid[0].size){
                if(grid[i][j]=='1'){
                    mapBoolean[i][j] = true
                }
            }
        }
        for(i in 0 until grid.size){
            for(j in 0 until grid[0].size){
                if(mapBoolean[i][j]){
                    answer+=1
                    bfs(grid,mapBoolean,Point(i,j))
                }
            }
        }
        
        return answer
    }
}