import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    val inOrder = br.readLine().split(" ").map { it.toInt() }
    val postOrder = br.readLine().split(" ").map { it.toInt() }
    divideInorder(inOrder, postOrder, 0, num - 1, 0, num - 1)
}

fun divideInorder(
    inOrder: List<Int>,
    postOrder: List<Int>,
    startInIndex: Int,
    endInIndex: Int,
    startPostIndex: Int,
    endPostIndex: Int
) {
    // 2
    if (startPostIndex > endPostIndex || startInIndex > endInIndex) {
        return
    }
    val root = postOrder[endPostIndex]

    // index = 5
    val findIndex = inOrder.indexOf(root)

    print("$root ")

    // //0,4
    val firstSize = findIndex - (startInIndex)
    divideInorder(inOrder, postOrder, startInIndex, findIndex - 1, startPostIndex, startPostIndex+firstSize-1)
    val twoSize = endInIndex - (findIndex)
    divideInorder(inOrder, postOrder, findIndex + 1, endInIndex, endPostIndex - twoSize, endPostIndex-1)


}
//   7
// 3   15
//1 5 12 16
//  4 6

// 인오더 (중위 순회)

// left root right
// 1 3 4 5 6 7 12 15 16

// left right root
// 1 4 6 5 3 12 16 15 7

//답 7 3 1 5 4 6 15 12 6 16

// 포스트 오더 (후위 순회)
// left right root
// 1 4 6 5 3 12 16 15 7

// 프리 오더 (전위 순화)
// root left right
// 7 3 1 5 4 6 15 12 6 16