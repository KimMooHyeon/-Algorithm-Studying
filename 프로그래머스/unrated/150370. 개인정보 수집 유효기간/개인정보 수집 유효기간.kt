val answer=mutableListOf<Int>()
data class Privacies(val year:Int, val month:Int, val day:Int,val term : Int, val index:Int){
    fun check(today: String){
        var newYear=year
        var newMonth=month+term
        var newDay=day
        if(day==1){
            newDay = 28
            newMonth-=1
        }else{
            newDay-=1
        }
        while(newMonth>12){
            newYear+=1
            newMonth = newMonth-12
        }
        var stDay=""
        var stMonth=""
        if(newDay<10){
            stDay="0"+newDay.toString()
        }else{
            stDay=newDay.toString()
        }
         if(newMonth<10){
            stMonth="0"+newMonth.toString()
        }else{
            stMonth=newMonth.toString()
        }
       if(newYear.toString()+stMonth+stDay<today.split(".").joinToString("")){
           answer.add(index)
       }
     // println("${newYear.toString()+stMonth+stDay}, 현재 ${today.split(".").joinToString("")}")
    }
}

class Solution {
    
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): MutableList<Int> {
        val hs = HashMap<String,Int>()
        terms.forEach{
            val (alpha,term)= it.split(" ")
            hs[alpha.toString()]=term.toInt()
        }
        privacies.forEachIndexed{ i,v->
            val(privacy,terms)=v.split(" ")
            val (year,month,day) = privacy.split(".").map{it.toInt()}
            
            var temp = Privacies(year,month,day,hs[terms]!!,i+1)
            temp.check(today)
        }
      
        return answer
    }
}