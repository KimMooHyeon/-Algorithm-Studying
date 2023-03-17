class Solution(object):
    def longestConsecutive(self, nums):
  
        nums = list(set(nums))
        nums.sort()
        curIndex = 0
        num = 1
        maxNum = 0
        if len(nums) == 0 :
            return 0
        while True :
            if curIndex >= len(nums)-1 :
                if maxNum < num :
                    maxNum = num
                    num=1
                break
            else:
                if nums[curIndex]+1 == nums[curIndex+1]:
                    print(nums[curIndex])
                    num+=1
                elif nums[curIndex] == nums[curIndex+1] :
                    pass
                else:
                    if maxNum < num :
                        maxNum = num
                    num=1
                curIndex+=1
        return maxNum

        """
        :type nums: List[int]
        :rtype: int
        """
        