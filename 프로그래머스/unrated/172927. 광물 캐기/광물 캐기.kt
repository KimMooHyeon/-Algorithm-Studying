class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0
        var costList = mutableListOf<IntArray>()
        var num = 0
        var index = -1
        var mineralSize = minerals.size
        minerals.forEachIndexed{ i, v ->
            index+=1
            var plusNum= 0
            when(v){
                "diamond"->{
                    plusNum=25
                }
                "iron"->{
                    plusNum=6
                }
                "stone"->{
                    plusNum=1
                }
            }
            if(index/4 == 1 && index%4 == 0){
                costList.add(intArrayOf(num+plusNum,costList.size))
                index=-1
                num=0
            }else if (i == minerals.size-1){
                costList.add(intArrayOf(num+plusNum,costList.size))
            }else{
                num+=plusNum
            }
        }
        var pickSize = 0
        picks.forEach{
            pickSize+=it
     
        }
        costList= costList.filter{it[1]<pickSize}.toMutableList<IntArray>()
        println(costList.size)
        costList.sortWith(compareBy{-it[0]})
        costList.forEach{
            println(it.contentToString())
            var pick=""
            if(picks[0]>0){
                pick="dia"
                picks[0]-=1
            }else if(picks[1]>0){
                pick="iron"
                picks[1]-=1
            }else if(picks[2]>0){
                pick="stone"
                picks[2]-=1
            }else{
                return answer
            }
            for(i in it[1]*5 until it[1]*5+5){
                if(i >= mineralSize){
                    break
                }else{
                    when(minerals[i]){
                        "diamond"->{
                            when(pick){
                                "dia"->{
                                    answer+=1
                                }
                                "iron"->{
                                    answer+=5
                                }
                                "stone"->{
                                    answer+=25
                                }
                                else->{}
                            }
                        }
                        "iron"-> {
                            when(pick){
                             "dia"-> {
                                answer+=1
                                }
                                "iron"-> {
                                    answer+=1
                                }
                                "stone"-> {
                                    answer+=5
                                }
                            }
                        }
                        "stone"-> {
                            answer+=1
                        }
                        else->{}
                    }
                }
            }
        }
        return answer
    }
}