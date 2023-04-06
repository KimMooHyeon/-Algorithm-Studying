class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val hashInt = HashMap<Int,String>()
        val hashString = HashMap<String,Int>()
        val num = players.size
        val answer= Array<String>(num){""}
        players.forEachIndexed{i,v->
            hashInt[i+1] = v
            hashString[v] = i+1
        }
        callings.forEach{
            // 4등
            val callNameInt = hashString[it]!!
            // 다음 등수인애 이름
            val tempName = hashInt[callNameInt-1]!!
            hashString[tempName] =callNameInt
            hashString[it] = callNameInt-1
            hashInt[callNameInt-1] = it
            hashInt[callNameInt] = tempName
        }
        for (i in 1 .. num){
            answer[i-1] = hashInt[i]!!
        }
        return answer
    }
}