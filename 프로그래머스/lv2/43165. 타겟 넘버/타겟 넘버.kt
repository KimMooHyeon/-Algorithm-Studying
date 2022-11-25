class Solution {
    lateinit var booleanList : BooleanArray
    var answer = 0
    
    fun solution(numbers: IntArray, target: Int): Int {
        booleanList = BooleanArray(numbers.size){true}
        dfs(0,0,numbers,target)
        return answer
    }
    fun dfs(index : Int, numbersSum:Int , numbers : IntArray,target:Int){
        if(index == numbers.size){
            if(numbersSum == target){
                answer+=1
            }
            return
        }
        if(booleanList[index]){
            booleanList[index]=false
            dfs(index+1,numbersSum+numbers[index],numbers,target)
            booleanList[index]=true
            dfs(index+1,numbersSum-numbers[index],numbers,target)
        }
    }
 
}