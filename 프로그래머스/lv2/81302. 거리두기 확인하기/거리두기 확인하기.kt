import kotlin.math.abs
import java.util.*
data class Point(val x:Int, val y :Int)
class Solution {
    fun getManDistance(a:Point,b:Point):Int{
        return abs(a.x-b.x) + abs(a.y-b.y)
    }
    fun bfs(map:Array<String>,curPlace:Point):Boolean{
        val queue = LinkedList<Point>()
        val hash=HashMap<Point,Boolean>()
        val xOffset = arrayOf(0,0,1,-1)
        val yOffset = arrayOf(1,-1,0,0)
        queue.add(curPlace)
        while(queue.isNotEmpty()){
            val place = queue.poll()
            hash[place]=true
            //    println()
            for(i in 0 .. 3) {
                val newX = place.x + xOffset[i]
                val newY = place.y + yOffset[i]
               // println("newX ${newX} newY ${newY}")
                if(newX >= 0 && newX<5 && newY >= 0 && newY<5){
                    val tempPoint = Point(newX,newY)
                   // println("들어옴 ${tempPoint} ${map[newY][newX]} ${tempPoint !in hash}")
                    if(tempPoint !in hash){
                            when(map[newY][newX].toString()){
                        "O"->{
                            if(getManDistance(curPlace,tempPoint)<2){
                                //println("newPoint ${tempPoint} ${map[newY][newX]}")
                                 queue.add(tempPoint)
                            }
                        }
                        "P"->{
                             if(getManDistance(curPlace,tempPoint)<=2 && tempPoint!=curPlace ){
                                       //     println("충돌발생 ${tempPoint} ${map[newY][newX]}")
                                return false
                            }
                        }
                      }
                    }
                }
            }
        }
        return true
    }
    fun solution(places: Array<Array<String>>): IntArray {
        var answer= IntArray(5){1}
        places.forEachIndexed{ index,place->
          //  println("[시작]  ${index+1}")
            var flag = false
            for (j in 0 .. 4){
                for(i in 0 .. 4){
                    if (place[j][i].toString() == "P"){
                      //  println(Point(i,j))
                        if(!bfs(place,Point(i,j))){
                          //  println("충돌")
                            answer[index]=0
                            flag=true
                            //break
                        }
                    }
                } 
                if(flag){
                    break
                }
            }
        }
        return answer
    }
}