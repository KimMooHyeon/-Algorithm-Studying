class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): ArrayList<IntArray> {
        var answer = arrayListOf<IntArray>()
        var mapArray = Array(arr1.size,{IntArray(arr2[0].size,{0})})
// 1 2 3 4    // 1 2
// 1 2 3 4    // 1 2
              // 1 2
              // 1 2      
        arr1.forEachIndexed{ index, list ->  
            for(arr2Index in 0 until arr2[0].size){
              list.forEachIndexed{ i , v ->
            mapArray[index][arr2Index]+= arr1[index][i] * arr2[i][arr2Index]   
               }
           }
        }
        mapArray.forEach{ it ->
            answer.add(it)
        }
    
        return answer
    }
}

