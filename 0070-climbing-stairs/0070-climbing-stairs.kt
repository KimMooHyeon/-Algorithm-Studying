class Solution {
    fun climbStairs(n: Int): Int {
        //1 , 2 , 3 , 4 ,5 ,6 ,7 ,8 ,9 ,10
        //1 , 1 , 2 , 3
        val climb = IntArray(n+1){0}
        if(n<3){
            if(n == 2){
                return 2
            }else{
                return 1    
            }
            
        }else{
             climb[1]=1
             climb[2]=2
            for(i in 3 .. n){
                climb[i] = climb[i-1]+climb[i-2]
            }
            return climb[n]
        }
    }
}