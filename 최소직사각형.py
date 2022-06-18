def solution(sizes):
    answer = 0
    max_1=[]
    max_2=[]
    for i in sizes:
        if i[0]>i[1]:
            max_1.append(i[0])
            max_2.append(i[1])
        else:
            max_1.append(i[1])
            max_2.append(i[0])
            
    print(max_1)
    print(max_2)
    
    
    return max(max_1)*max(max_2)