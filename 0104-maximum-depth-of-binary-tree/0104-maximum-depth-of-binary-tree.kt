/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
import java.util.*
class Solution {
    fun bfs(root: TreeNode?): Int {
        var maxNum = 0
        if (root == null) {
            return 0
        }
        var queue = LinkedList<Pair<TreeNode?,Int>>()
        queue.add(Pair(root, 1))
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            maxNum = maxOf(maxNum, temp.second)
            if (temp.first!!.left != null) {
                queue.add(Pair(temp.first!!.left, temp.second + 1))
            }
            if (temp.first!!.right != null) {
                queue.add(Pair(temp.first!!.right, temp.second + 1))
            }
        }
        return maxNum
    }
    
    fun dfs(root:TreeNode?) : Int{
        if (root == null){
            return 0
        }
        val left = dfs(root.left)
        val right = dfs(root.right)
        return maxOf(left,right)+1
    }
    fun maxDepth(root: TreeNode?): Int {
        println(bfs(root))
        return bfs(root)
    }
}