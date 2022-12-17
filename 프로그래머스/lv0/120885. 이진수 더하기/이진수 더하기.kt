import java.util.*
class Solution {
    fun solution(bin1: String, bin2: String)= toBin(toDec(bin1) +toDec(bin2))
    
    fun toBin(num :Int):String{
        return Integer.toBinaryString(num)
    }
    fun toDec(bin:String):Int{
        var returnNumber = 0
        var index = 0
        for(i in bin.length-1 downTo 0){
            returnNumber+=(mu(index,(bin[i].toString().toInt())))
            index+=1
          //  returnNumber += mu(index,(bin[i].toString().toInt()))
        }
        return returnNumber
    }
    fun mu(index:Int, number : Int):Int{
        if(number == 0){
            return 0
        }
        var a = 1 
        for(i in 0 until index){
            a*=2
        }
        return a
    }
}