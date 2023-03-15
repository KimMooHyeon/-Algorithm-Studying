class Solution(object):
    def twoSum(self, nums, target):
        num = []
        for i in range(0,len(nums)):
            num.append((nums[i],i))

        num = sorted(num, key=lambda x : x[0])
        start = 0
        end = len(num) - 1
        returnList = []
 
        while(start<end):
            if num[start][0] + num[end][0] == target:
                returnList = [num[start][1] , num[end][1] ]
                break
            elif num[start][0] + num[end][0] < target:
                start+=1
            else:
                end-=1
        return returnList