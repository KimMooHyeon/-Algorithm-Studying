class Solution {
    fun solution(food: IntArray): String {
    var answer: String = ""
       var newFood = food.map{it-(it%2)}
       var foodSize = newFood.sum()
       var tempArray = Array(foodSize+1,{0})
       var start = 0
       for (i in 1 until newFood.size){
           for(index in 0 until newFood[i]/2){
               tempArray[start]=i
               tempArray[tempArray.size-1-start]=i
               start+=1
           }
       }
        tempArray.forEach{
            print("$it ")
        }
    
        return tempArray.joinToString("")
    }
}