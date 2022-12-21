
class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        val gcdNum = gcd(a,b)
        var checkNum = b/gcdNum
        while(true){
            if(checkNum%2 ==0){
                checkNum/=2
            }else if(checkNum%5 ==0){
                checkNum/=5
            }else{
                break
            }
        }
        return if (checkNum==1) 1 else 2
    }
    fun gcd(a : Int ,b:Int):Int{
        if(a>b){
            return if (a%b ==0) b else gcd(a%b,b)
        }else{
            return if (b%a ==0) a else gcd(b%a,a)
        }
        
    }
}