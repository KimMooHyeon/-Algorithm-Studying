def solution(s, skip, index):
    answer = ''
    skipChar = {}
    for i in skip :
        skipChar[i] = True

    for i in s :
        num = 0 
        curIndex = ord(i)
        while True:
            curIndex += 1
            
            if curIndex == 123:
                curIndex = 97
                
            if chr(curIndex) in skipChar : 
                pass
            else:
                pass
                num+=1
                
            if curIndex == 123:
                curIndex = 97

            if num == index :
                answer+= chr(curIndex)
                break
        
        
    return answer