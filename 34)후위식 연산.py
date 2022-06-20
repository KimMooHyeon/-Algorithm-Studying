import sys
#sys.stdin=open("input.txt","rt")
res=""
answer=0
#N,M = map(int,input().split())
#N_arr= list(map(int,input().split()))
input_string=input()
stack=[]

for i in input_string:
    if '0'<= i <='9':
        stack.append(i)
    else:
        a=int(stack.pop())
        b=int(stack.pop())
        if i =='+':
            stack.append(str(a + b))
        elif i=='*':
            stack.append(str(a * b))
        elif i=='-':
            stack.append(str(b - a))
        elif i=='/':
            stack.append(str(b / a))


print(stack[-1])

