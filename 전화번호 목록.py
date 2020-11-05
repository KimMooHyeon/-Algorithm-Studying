def solution(phone_book):
    phone_book.sort()
    print(phone_book)
    answer = True
    for i in range(len(phone_book)-1):
        for j in range (i+1,len(phone_book)) :
            for k in range(min(len(phone_book[i]),len(phone_book[j]))):
                if k == min(len(phone_book[i]),len(phone_book[j]))-1 :
                    if phone_book[i][k]==phone_book[j][k] :
                        return False
                else:
                    if phone_book[i][k]!=phone_book[j][k] :
                        break
    return answer