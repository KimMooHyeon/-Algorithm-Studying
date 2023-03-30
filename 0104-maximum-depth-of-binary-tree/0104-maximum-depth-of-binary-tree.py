# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    max = 0
    def maxDepth(self, root, depth=0):
        if root == None :
            return 0
        if root.left == None and root.right == None :
            return depth + 1
        left = self.maxDepth(root.left,depth+1)
        right = self.maxDepth(root.right,depth+1)
    
        return max(left,right)
    
        