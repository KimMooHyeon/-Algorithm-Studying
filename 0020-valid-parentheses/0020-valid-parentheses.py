class Solution(object):
    def isValid(self, s):
        hs = {}
        hs[")"]="("
        hs["]"]="["
        hs["}"]="{"
        
        paren = []
        for i in s :
            if paren :
                if i not in hs :
                    paren.append(i)
                else:
                    if paren[-1] == hs[i] :
                        paren.pop()
                    else :
                        paren.append(i)
            else:
                paren.append(i)
        print(paren)
        if len(paren) == 0 :
            return True
        else :
            return False
        """
        :type s: str
        :rtype: bool
        """
        