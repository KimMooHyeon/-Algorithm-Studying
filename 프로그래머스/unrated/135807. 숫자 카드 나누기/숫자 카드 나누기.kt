class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer: Int = 0
        arrayA.sort()
        arrayB.sort()
        var aList = 0
        var bList = 0
        for(i in arrayA[0] downTo 1 ){
            if(arrayA.all{it%i == 0}){
                aList=i
                break
            }
        }
         for(i in arrayB[0] downTo 1 ){
            if(arrayB.all{it%i == 0}){
                bList=i
                break
            }
        }
         println(aList)
         println(bList)
         if(arrayB.all{it%aList != 0} || arrayA.all{it%bList != 0} ){
             var a = 0
             var b = 0
             if(arrayB.all{it%aList != 0}){
                 a = aList
             }
              if(arrayA.all{it%bList != 0}){
                 b = bList
             }
              if(a>b){
                  answer = a
              }else{
                   answer = b
              }
         }
        return answer
    }
}