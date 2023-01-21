data class Person(val userIndex:Int, 
                  val percent : Int, 
                  val price :Int){
    fun calPrice(emojiList:MutableList<Emoji>):Int{
        var sum = 0
        emojiList.forEach{
            if(it.isBuy(percent)){
               sum+=it.calPrice()
            }
        }
        return sum
    }
}

data class Emoji(var percent:Int, var price:Int) {
    fun calPrice():Int{
        return price-((price*percent)/100)
    }
    fun isBuy(personPercent:Int):Boolean{
        return if(personPercent<=percent){
            true
        }else{
            false
        }
    }
}

val p = listOf(10,20,30,40)
val personList = mutableListOf<Person>()
var answerSub=0
var answerPrice=0

class Solution {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
 
        users.forEachIndexed{i,v->
            personList.add(Person(i,v[0],v[1]))
        }
      
        dfs(0,mutableListOf<Emoji>(),emoticons)
        return intArrayOf(answerSub,answerPrice)
    }
    fun dfs(index:Int,emojiList:MutableList<Emoji>, emoticons: IntArray){
        if(emojiList.size==emoticons.size){
            var tempSub=0
            var tempPrice=0
            personList.forEach{ person->
                val myPersonSum =person.calPrice(emojiList)
                if(myPersonSum>=person.price){
                    tempSub+=1
                }else{
                    tempPrice+=myPersonSum
                   // println(myPersonSum)
                }
            }
            if(answerSub==tempSub){
                if(answerPrice<tempPrice){
                    answerPrice=tempPrice
                }
            }else if(answerSub<tempSub){
                 answerSub=tempSub
                 answerPrice=tempPrice
            }

            return
        }else{
            for(i in 0 .. 3){
                val temp =Emoji(p[i],emoticons[index])
                emojiList.add(temp)
                dfs(index+1,emojiList,emoticons)
                emojiList.remove(temp)
            }
        }
    }
}