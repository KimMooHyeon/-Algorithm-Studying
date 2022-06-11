import sys
#sys.stdin=open("input.txt","rt")


N,C = map(int,input().split())
#N = int(input())
#N_arr=list(map(int,input().split()))
xi_arr=[]
xi_arr.sort()

def check_fun(arr,N,C,middle):
    # C 말의 수 == cnt
    minus_num=0
    cnt=1
    index=1
    lf_index=0
    while index<N :
        minus_num=arr[index]-arr[lf_index]
        if minus_num>=middle:
            # 마굿간 사이의 간격이 설정된 거리보다 떨어져있음
            cnt+=1
            lf_index=index
            index+=1
            if cnt >=C :
                return True 
                # 성공
        else:
            index+=1

            # 마굿간 사이의 간격이 설정된 거리보다 가까움
    return False
    

      

for i in range (N):
    tmp = int(input()) 
    xi_arr.append(tmp)

lf= xi_arr[0]
rf = xi_arr[-1]
res_cnt=0
while lf<=rf:
    middle=(lf+rf)//2
    if check_fun(xi_arr,N,C,middle):
        lf=middle+1
        if res_cnt<middle:
            res_cnt=middle
    else:
        rf=middle-1
print(res_cnt)
        

