def solution(phone_book):
    answer = True
    phoneLen=set([])
    phone_book.sort(key=lambda x : len(x))
    checkHash={}
    for i in phone_book :
        for num in phoneLen :
            if i[0:num] in checkHash:
                return False
        phoneLen.add(len(i))
        checkHash[i]=True
            
            
        
    return answer