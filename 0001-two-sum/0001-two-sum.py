class Solution(object):
    def twoSum(self, nums, target):
        dict = {}
        for i,v in enumerate (nums):
            dict[v]=i
        for i,v in enumerate (nums) :
            if target-v in dict and i!=dict[target-v]:
                return [i,dict[target-v]]
        return [0]