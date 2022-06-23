from collections import deque
from itertools import permutations
from itertools import combinations
from itertools import product

import sys
#sys.stdin=open("input.txt","rt")

N,M= map(int,input().split())

tmp=[x+1 for x in range(N)]


tmp3=list(product(tmp, repeat=M))

for i in tmp3 :
    for j in range(M):
        print(i[j], end=' ')
    print("")
print(len(tmp3))
