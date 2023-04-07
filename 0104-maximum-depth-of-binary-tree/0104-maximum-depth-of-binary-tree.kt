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
class Solution {
    fun dfs(root:TreeNode?) : Int{
        if (root == null){
            return 0
        }
        val left = dfs(root.left)
        val right = dfs(root.right)
        return maxOf(left,right)+1
    }
    fun maxDepth(root: TreeNode?): Int {
        return dfs(root)
    }
}