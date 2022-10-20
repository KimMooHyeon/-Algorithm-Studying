class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val mbtiList = mutableMapOf<Char, Int>('R' to 0,'T' to 0,'C' to 0,'F' to 0,'J' to 0,'M' to 0,'A' to 0,'N' to 0 )

     
        for (i in 0 until choices.size) {
            when (choices[i]) {
                1 -> {
                    mbtiList[survey[i][0]]?.let{
                     mbtiList[survey[i][0]] = it + 3
                    } 
                }
                2 -> {
                   mbtiList[survey[i][0]]?.let{
                     mbtiList[survey[i][0]] = it + 2
                    } 
                }
                3 -> {
                    mbtiList[survey[i][0]]?.let{
                     mbtiList[survey[i][0]] = it + 1
                    } 
                }
                4 -> {

                }
                5 -> {
                    mbtiList[survey[i][1]]?.let{
                     mbtiList[survey[i][1]] = it + 1
                    } 
                }
                6 -> {
                    mbtiList[survey[i][1]]?.let{
                     mbtiList[survey[i][1]] = it + 2
                    } 
                }
                7 -> {
                    mbtiList[survey[i][1]]?.let{
                     mbtiList[survey[i][1]] = it + 3
                    } 
                }
                else -> {

                }
            }
        }
     if(mbtiList['R']!! >= mbtiList['T']!!){
          answer+="R"
      }else{
          answer+="T"
      }
     if(mbtiList['C']!! >= mbtiList['F']!!){
          answer+="C"
      }else{
          answer+="F"
      }
      if(mbtiList['J']!! >= mbtiList['M']!!){
          answer+="J"
      }else{
          answer+="M"
      }
       if(mbtiList['A']!! >= mbtiList['N']!!){
          answer+="A"
      }else{
          answer+="N"
      }
        return answer
    }
}