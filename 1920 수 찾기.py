import sys
#sys.stdin=open("input.txt", "r")

def find_num(arr,num):
    left = 0
    right = len(arr)-1

    while left<right:
        middle = (left+right)//2
     
        if arr[middle] == num :
            return True
        elif arr[middle] < num :
            left=middle+1
            
        else:
            right=middle-1

        if left == right :
            if arr[(left+right)//2] == num :
                return True
            else:
                return False

    return False

        

N =int(input())
N_arr= list(map(int,input().split()))
N_arr.sort()
M =int(input())
M_arr= list(map(int,input().split()))

for i in M_arr:
    if find_num(N_arr,i):
        print(1)
    else:
        print(0)