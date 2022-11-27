import java.math.BigInteger

class Solution {
    fun solution(balls: Int, share: Int): BigInteger {
        var answer: BigInteger  = 0.toBigInteger()
        var topNum : BigInteger =1.toBigInteger()
        var bottomleftNum : BigInteger =1.toBigInteger()
        var bottomrightNum : BigInteger  =1.toBigInteger()
        for (i in balls downTo 1){
            topNum*=i.toBigInteger()
        }
        for (i in balls-share downTo 1){
            bottomleftNum*=i.toBigInteger()
        }
        for (i in share downTo 1){
            bottomrightNum*=i.toBigInteger()
        }

        return topNum/(bottomleftNum*bottomrightNum)
    }


}