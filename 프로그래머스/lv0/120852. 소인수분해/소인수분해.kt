class Solution {
    fun solution(n: Int): IntArray {
        var answer = mutableSetOf<Int>()
        var sosu = mutableListOf<Int>()
        var sosuList = Array(n+1){true}
        
        for(i in 2 .. n){
            if(sosuList[i]){
                sosu.add(i)
                for(j in i .. n step i){
                    sosuList[j]=false
                }
            }
        }
        var num = n
        var index =0
        if(n in sosu){
            answer.add(n)
        }else{
            while(true){
                if(num ==1){
                    break
                }
                if(index>=sosu.size){
                    break
                }
                if((num%sosu[index])==0){
                    answer.add(sosu[index])
                    num/=sosu[index]
                }else{
                    index+=1
                }
            }
        }
        return answer.toIntArray()
    }
}