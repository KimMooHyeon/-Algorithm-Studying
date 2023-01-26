class Solution {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        var tempStorey = storey
        var storeyString =storey.toString()
        var zisu = storeyString.length
        
        while(tempStorey >= 10){
            var temp1 = tempStorey%10
            if(temp1>5){
                answer+=(10-temp1)
                tempStorey/=10
                tempStorey+=1
            }else if(temp1<5){
                answer+=temp1
                tempStorey/=10
            }else if(temp1 == 5){
                answer+=temp1
                var tem = tempStorey
                while(true){
                    if(tempStorey == 5){
                        tempStorey=0
                        answer+=5
                        break
                    }
                    if(tem == 5){
                        tempStorey/=10
                         tempStorey+=1
                        break
                    }
                     var temp = tem/10 // 55
                     var temp2 = temp%10 //5
                    if(temp2>5){
                          tempStorey/=10
                          tempStorey+=1
                        break
                    }else if (temp2<5){
                        tempStorey/=10
                        break
                    }else {
                          tem/=10
                    }
                }
            }
        }

        if(tempStorey>5){
            return answer+ 10-tempStorey+1
        }else{
           return  answer+tempStorey
        }
    }
}