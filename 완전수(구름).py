import sys

A, B = map(int, sys.stdin.readline().split())


def check(user_input):
    ans = 0
    i = 1
    while i * i <= user_input:
        #	print(i)
        if user_input % i == 0:
            ans += i
            if i != user_input // i and user_input != user_input // i:
                ans += (user_input // i)
        i += 1
    #	print(ans)
    if ans == user_input:
        return True
    else:
        return False


for i in range(A, B + 1):
    if check(i):
        if i != 1:
            print(i, end=' ')