class Solution {
     val hs = HashMap<Long,Long>()
    fun solution(k: Long, room_number: LongArray): LongArray {
        var answer = LongArray(room_number.size)
        for(i in 0 .. room_number.size-1){
            answer[i]=findUserRoom(room_number[i])
        }
        return answer
    }
    fun findUserRoom(roomNumber:Long):Long{
        if(!hs.containsKey(roomNumber)){
            hs[roomNumber]=roomNumber+1
            return roomNumber
        }
        val next = hs[roomNumber]!!
        val empty = findUserRoom(next)
        hs[roomNumber] = empty

        return empty
    }
}