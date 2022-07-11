N=int(input())
res=0
for i in range(1,N+1):
    X=list(str(i))
    if len(X) == 1 :
        res+=1
    else:
        cnt=int(X[1])-int(X[0])
        for index in range(1,len(X)-1) :
            tmp_num=int(X[index+1])-int(X[index])
            if tmp_num != cnt :
                break
        else:
            res+=1

print(res)
   
        