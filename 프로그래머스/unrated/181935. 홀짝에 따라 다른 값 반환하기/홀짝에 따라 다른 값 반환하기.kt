class Solution {
    fun solution(n: Int) = if(n%2 == 0) {
        (1..n).toList().filter { it%2==0 }.map { it*it }.sum()
    }else if(n%2 == 1){
        (1..n).toList().filter { it%2==1 }.sum()
    }else{
        0
    }
}