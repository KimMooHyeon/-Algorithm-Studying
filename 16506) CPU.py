import sys
#sys.stdin=open("input.txt","rt")

def change2 (num,check):
    res=[]
    tmp=0
    num=int(num)
    while True:
        if num < 2 :
            res.append(num)
            break
        tmp=num%2
        res.append(tmp)
        num=num//2
        
    res.reverse()
    re_str=""
    cnt_num=check
    if len(res)<check:
        for i in range(cnt_num-len(res)):
            re_str+="0"

    for i in res :
        re_str+=str(i)
    return re_str


def change_Asemble(arr):
    global asm_arr
    res=""
    res+=asm_arr[arr[0]]
    res+="0"
    res+=change2(arr[1],3)
    res+=change2(arr[2],3)
    if res[4] == '0':
        if len(change2(arr[3],3))==3:
            res+= (change2(arr[3],3)+'0')
        else:
            res+= (change2(arr[3],3))

    else:
        res+= (change2(arr[3],4))

    return res

#N,M = map(int,input().split())
N=int(input())
N_arr=[]
for i in range(N):
    tmp= list(input().split())
    N_arr.append(tmp)
#N_arr= list(map(int,input().split()))

asm_arr={'ADD':'00000','ADDC':'00001','SUB':'00010' ,'SUBC':'00011'
         ,'MOV':'00100' ,'MOVC':'00101' ,'AND':'00110' ,'ANDC':'00111'
         ,'OR':'01000' ,'ORC':'01001' ,'NOT':'01010' ,'MULT':'01100'
         ,'MULTC':'01101' ,'LSFTL':'01110' ,'LSFTLC':'01111' ,'LSFTR':'10000' 
         ,'LSFTRC':'10001' ,'ASFTR':'10010' ,'ASFTRC':'10011','RL':'10100' 
         ,'RLC':'10101' ,'RR':'10110' ,'RRC':'10111'} 


for i in N_arr:
    print(change_Asemble(i))



# MOVC 1 0 5 
# 0010 1 0 001 000 0101
# 0010 1 0 001 000 101
# 0010 1 0 001 000 0000
#ADD 3 1 2
#000 00 0 011 001 010 0

