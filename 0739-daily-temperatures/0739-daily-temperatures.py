class Solution(object):
    def dailyTemperatures(self, temperatures):
        temList = []
        returnList = []
        
        for i in range(0,len(temperatures)):
            returnList.append(0)
            
        for i,v in enumerate(temperatures) :
            if temList :
                if v <= temList[-1][1] :
                    temList.append([i,v])
                else :

                    while(temList[-1][1] < v):
                        tem = temList.pop()
                        returnList[tem[0]]=i-tem[0]
                        if len(temList) == 0 :
                            break
                    temList.append([i,v])
            else:
                temList.append([i,v])
                
        return returnList
    
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        