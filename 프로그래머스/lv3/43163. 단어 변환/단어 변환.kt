class Solution {
    lateinit var booleanArray : BooleanArray
    lateinit var wordsArray : Array<String>
    lateinit var targetString : String
    var answer = 0
    fun solution(begin: String, target: String, words: Array<String>): Int {
        answer = words.size+1
        targetString= target
        wordsArray=words
        booleanArray = BooleanArray(words.size){true}
        
        if(target !in words){
            return 0
        }
        dfs(begin,0)
        if(answer == words.size+1){
            answer = 0
        }
        return answer
    }
    
    fun dfs(begin : String ,num:Int){
        if(begin == targetString){
            if(answer>num){
                answer=num
            }
            return
        }
        if(answer<=num){
            return
        }
        wordsArray.forEachIndexed{ index,word->
            if(booleanArray[index]){
                if(checnOneDifferent(begin,word)){
                    booleanArray[index]=false
                    dfs(word,num+1)
                     booleanArray[index]=true
                }
                
            }
        }
    }
    
    fun checnOneDifferent(a : String , b : String):Boolean{
        var returnVal = false
        var differentNum = 0
        val aList = a.toList()
        val bList = b.toList()
        if(a == b){
            return returnVal
        }
        for (i in 0 until aList.size){
            if(aList[i]!=bList[i]){
                differentNum+=1
            }
            if(differentNum>1){
                return false
            }
        }
        if(differentNum == 1){
            returnVal = true
        }
        return returnVal
    }
}