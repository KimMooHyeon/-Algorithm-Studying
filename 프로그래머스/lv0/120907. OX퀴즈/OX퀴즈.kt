class Solution {
    fun solution(quiz: Array<String>): ArrayList<String> {
        var answer: ArrayList<String> = arrayListOf<String>()
        quiz.forEach{
            var sum=0
            var index =0
            val temp = it.split(" ").map{it.toString()}
            
            while(index < temp.size-2){
             when(temp[index]){
                 "-"->{
                     index+=1
                     sum-=temp[index].toInt()
                     index+=1
                 }
                  "+"->{
                     index+=1
                     sum+=temp[index].toInt()
                     index+=1
                 }
                  else->{
                     sum+=temp[index].toInt()
                     index+=1
                  }
             }
            }
            if(sum == temp[temp.size-1].toInt() ){
                answer.add("O")
            }else{
                answer.add("X")
            }
           // println(sum)
        }
        return answer
    }
}