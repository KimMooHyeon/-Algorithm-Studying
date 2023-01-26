class Solution {
    var answer: Int = -1

    fun solution(x: Int, y: Int, n: Int): Int {
        val dp = Array(y + 1) { 1000000 }
        val booleanDp = BooleanArray(y + 1) { true }

        dp[x] = 0
        booleanDp[x] = false
        dp[0] = 0

// 10  -> 40	+5	[2번]
        for (i in x..y) {

            var one = 1000000
            var two = 1000000
            var three = 1000000
            if (i - n >= x) {
                one = dp[i - n] + 1
            }
            if (i % 2 == 0) {
                two = dp[i / 2] + 1
            }
            if (i % 3 == 0) {
                three = dp[i / 3] + 1
            }
            dp[i] = minOf(one, two, three, dp[i] )


        }

        if (dp[y] == 1000000) {
            dp[y] = -1
        }
        return dp[y]
    }

}