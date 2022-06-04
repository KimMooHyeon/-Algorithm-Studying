import sys
#sys.stdin=open("input.txt","rt")

def reverse(x):
    str_x= list(str(x))
    str_x.reverse()
    res_str=""
    for i in str_x:
        res_str+=i
    return int(res_str)
    


def isPrime(x):
    for i in range(2,x) :
       if x % i == 0:
           return False
           break
    else :
        if x ==1 :
            return False
        return True


N = int(input())
N_arr = list(map(int,input().split()))

for i in N_arr:
    if isPrime(reverse(i)):
        print(reverse(i),   end = ' ')