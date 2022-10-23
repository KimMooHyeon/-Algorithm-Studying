class Solution {
    fun solution(denum1: Int, num1: Int, denum2: Int, num2: Int): IntArray {
        var answer: IntArray 
        var gcdNum =gcd(num1,num2) 

        var bNum = (num1*num2)/gcdNum
        var aNum1 = (bNum/num1) * denum1 
        var aNum2 = (bNum/num2) * denum2 
        var a = gcd(aNum1+aNum2,bNum)
    answer = intArrayOf((aNum1+aNum2)/a,bNum/a)
        
        return answer
    }
    fun gcd(a : Int, b : Int): Int{
        var returnNum = 1
     if(a>b){
         for (i in 1 .. b){
             if(a%i ==0 && b%i ==0){
                 returnNum=i
             }
         }
     }else{
           for (i in 1 .. a){
             if(a%i ==0 && b%i ==0){
                 returnNum=i
             }
         }
     }
     return returnNum
}
}