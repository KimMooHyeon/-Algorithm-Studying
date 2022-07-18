N=int(input())

for i in range(N):
    tmp=N-(i+1)
    for j in range(N):
        if tmp <= j :
            print("*",end='')
        else:
            print(" ",end='')
    print("")