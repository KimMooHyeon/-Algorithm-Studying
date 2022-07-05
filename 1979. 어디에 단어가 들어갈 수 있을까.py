T = int(input())

for test_case in range(1, T + 1):
    
    N,K =map(int,input().split())
    map_nrr=[]
    ans_arr=[]
    tmp_arr=[]
    res=0
    for i in range(N):
        tmp= list(map(str,input().split(' ')))
        ans_arr.append(tmp)
        tmp="".join(tmp)
        tmp= tmp.split('0')
        for j in tmp:
            if j.isdigit():
                map_nrr.append(j)

    for j in range(0,N):
        tmp_arr2=[]
        for k in range(0,N):
            tmp=ans_arr[k][j]
            tmp_arr2.append(tmp)

        tmp_arr.append(tmp_arr2)

    for k in tmp_arr:
        k="".join(k)
        k= k.split('0')
        for j in k:
            if j.isdigit():
                map_nrr.append(j)
                
    for i in map_nrr:
        if len(i) == K :
            res+=1

    print(f"#{test_case} {res}")