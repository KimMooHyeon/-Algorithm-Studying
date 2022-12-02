class Solution {
    fun solution(my_str: String, n: Int): ArrayList<String> {
        var answer: ArrayList<String> = arrayListOf<String>()
        for(i in 0 .. my_str.length-n step n){
            var temp=""
            for(j in i until i+n){
                temp+=(my_str[j])
            }
            answer.add(temp)
            temp=""
      
        }
        if(my_str.length%n !=0){
            var temp = ""
            for(i in my_str.length-my_str.length%n until my_str.length){
                temp+=(my_str[i])
            }
             answer.add(temp)
        }
        return answer
    }
}