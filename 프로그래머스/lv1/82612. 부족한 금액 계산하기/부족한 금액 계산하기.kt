class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = -1
        var sum : Long = 0
        repeat(count){
            sum+=((it+1)*price)
        }
        if(money>=sum){
            return 0
        }else{
            return sum-money
        }
        return answer
    }
}