import java.util.*

data class Point(val y : Int, val x:Int,val cost:Int)

class Solution {
    fun bfs(map:Array<IntArray>,m:Int,n:Int){
        val queue = LinkedList<Point>()
        val xOffset = listOf(1,0)
        val yOffset = listOf(0,1)
        if(m ==1 ||n ==1){
            return
        }
        queue.add(Point(1,1,2))
        map[1][1]=2
        while(queue.isNotEmpty()){
            val curQueue = queue.poll()
            for(i in 0 .. 1){
                val nextX = curQueue.x + xOffset[i]
                val nextY = curQueue.y + yOffset[i]
                if(0<= nextX && nextX<n && 0<=nextY && nextY<m){
                        if(map[nextY][nextX]==0){
                             map[nextY][nextX] = map[nextY][nextX-1] + map[nextY-1][nextX]
                        queue.add(Point(nextY,nextX,map[nextY][nextX-1] +map[nextY-1][nextX]))
                        }
                    }
                }
            }
    }
    fun uniquePaths(m: Int, n: Int): Int {
        val map = Array(m){IntArray(n){0}}
        for(i in 0 until m){
             map[i][0] = 1
        }
         for(i in 0 until n){
             map[0][i] = 1
        }
        bfs(map,m,n)
        return map[m-1][n-1]
    }
}