import java.util.*
data class Point(val y:Int,val x:Int)

val myGraph = mutableListOf<Point>()
class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        var answer: DoubleArray = DoubleArray(ranges.size){0.0}
        solK(k,0)
        ranges.forEachIndexed{ i,v ->
          //  println("range ${v[0]} ${v[1]}")
            answer[i] = calRangeResult(v[0],v[1])
          //  println("${answer[i] }")
        }

        return answer
    }
}
fun calRangeResult(start:Int,end:Int):Double{
    val startIndex=start
    var end = myGraph.size+end

  //println("in range ${start} ${end}")
    var returnNum= 0.0 
    if(startIndex>=end){
        return -1.0
    }else{
          for(i in startIndex until end-1){
           val temp = calcul(myGraph[i],myGraph[i+1])
          // println("temp = ${temp}")
           returnNum+=temp
        }
    }
    return returnNum
}
fun solK(k:Int,index:Int){
  when{
      k==1 ->{
           myGraph.add(Point(k,index))
           return
      }
      k%2 == 0 ->{
        myGraph.add(Point(k,index))
        solK(k/2,index+1)
      } 
       k%2 != 0 ->{
        myGraph.add(Point(k,index))
        solK(k*3 +1,index+1)
      }
      else->{}
  }
}
fun calcul(a :Point, b :Point):Double{
    val x : Double = 1.0 
    var bigY: Double  = 0.0
    var smallY : Double = 0.0
    
    if(a.y>b.y){
        bigY=(a.y).toDouble()
        smallY=(b.y).toDouble()
    }else{
        bigY=(b.y).toDouble()
        smallY=(a.y).toDouble()
    }
    return  bigY - (bigY-smallY)/2
}