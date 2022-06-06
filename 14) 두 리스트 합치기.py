import sys
import math
#sys.stdin=open("input.txt","rt")



N = input()
N_arr = list(map(int,input().split()))
M = input()
M_arr = list(map(int,input().split()))

res_arr= N_arr+M_arr
res_arr.sort()


for i in res_arr :
    print(i,end = ' ')
