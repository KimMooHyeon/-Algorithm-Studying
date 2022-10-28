class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        for(i in babbling){
            var sentence = i
            sentence=sentence.replace("aya","1")
            sentence=sentence.replace("ye","2")
            sentence=sentence.replace("woo","3")
            sentence=sentence.replace("ma","4")
            var bfChar = 'A'
            var check = true
            for(st in sentence){
                if (st in 'a' .. 'z'){
                    check=false
                    break
                }else{
                    if (st == bfChar){
                          check=false
                        break
                    }else{
                        bfChar=st
                    }
                }
            }
            if(check)  answer+=1
            println(sentence)
        }
        return answer
    }
}