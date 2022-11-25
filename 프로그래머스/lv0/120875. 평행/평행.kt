class Solution {
    fun solution(dots: Array<IntArray>): Int {
        var answer: Int = 0
        val dotsFloat = dots.map { it.map { it.toFloat() } }
        var ansList = mutableListOf<Pair<Float, Float>>()
        if (dotsFloat[0][0] - dotsFloat[1][0] != 0F && (dotsFloat[0][1] - dotsFloat[1][1]) != 0F && (dotsFloat[2][0] - dotsFloat[3][0]) != 0F && (dotsFloat[2][1] - dotsFloat[3][1]) != 0F) {
            ansList.add(
                Pair(
                    (dotsFloat[0][0] - dotsFloat[1][0]) / (dotsFloat[0][1] - dotsFloat[1][1]),
                    (dotsFloat[2][0] - dotsFloat[3][0]) / (dotsFloat[2][1] - dotsFloat[3][1])
                )
            )
        }

        if ((dotsFloat[0][0] - dotsFloat[2][0]) != 0F && (dotsFloat[0][1] - dotsFloat[2][1]) != 0F && (dotsFloat[1][0] - dotsFloat[3][0]) != 0F && (dotsFloat[1][1] - dotsFloat[3][1]) != 0F) {
            ansList.add(
                Pair(
                    (dotsFloat[0][0] - dotsFloat[2][0]) / (dotsFloat[0][1] - dotsFloat[2][1]),
                    (dotsFloat[1][0] - dotsFloat[3][0]) / (dotsFloat[1][1] - dotsFloat[3][1])
                )
            )
        }

        if ((dotsFloat[0][0] - dotsFloat[3][0]) != 0F && (dotsFloat[0][1] - dotsFloat[3][1]) != 0F && (dotsFloat[1][0] != 0F && (dotsFloat[1][1] - dotsFloat[2][1]) != 0F)){
            ansList.add(
                Pair(
                    (dotsFloat[0][0] - dotsFloat[3][0]) / (dotsFloat[0][1] - dotsFloat[3][1]),
                    (dotsFloat[1][0] - dotsFloat[2][0]) / (dotsFloat[1][1] - dotsFloat[2][1])
                )
            )
        }
        ansList.forEach{
            if(it.first == it.second){
                answer=1
            }
        }

        println (ansList.toString())
        return answer
    }
}