import sys

#sys.stdin=open("input.txt","rt")

N= int(input())
N_arr=[]
N_dic={}
for i in range(N):
    tmp=input()
    N_arr.append(tmp)
    cnt=0
for i in N_arr:
    N_dic.clear()
    before=""
    for j in i :
        if j not in N_dic:
            N_dic[j]=1
            before=j
        else:
            if before==j:
                pass
            else:
                break
    else:
        cnt+=1
print(cnt)



