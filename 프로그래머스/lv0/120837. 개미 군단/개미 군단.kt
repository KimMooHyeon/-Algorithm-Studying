class Solution {
    fun solution(hp: Int): Int {
        var answer: Int = 0
        var hpNum = hp
        while(hpNum != 0){
            if(hpNum>=5){
                answer+=hpNum/5
                hpNum%=5
            }
             if(hpNum>=3){
                answer+=hpNum/3
                hpNum%=3
            }
              if(hpNum>=1){
                answer+=hpNum/1
                hpNum%=1
            }
        }
        return answer
    }
}