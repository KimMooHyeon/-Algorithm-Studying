class Solution {
    fun solution(id_pw: Array<String>, db: Array<Array<String>>): String {
        var answer: String = ""
        var temp = db.filter{it[0]==id_pw[0]}
        if(temp.isEmpty()){
            return "fail"
        }else{
           if (temp.any { it[0]==id_pw[0] && it[1]==id_pw[1]}){
               return "login"
           }else{
               return "wrong pw"
           }
        }
        return answer
    }
}