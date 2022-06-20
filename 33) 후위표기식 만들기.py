import sys
#sys.stdin=open("input.txt","rt")
res=""
#N,M = map(int,input().split())
#N_arr= list(map(int,input().split()))
input_string=input()
stack=[]

for i in input_string:
    if '0'<= i <='9':
        res+=i
    else:
        if i =='(' :
            stack.append(i)
        elif i== '*' or i == '/':
            while stack and (stack[-1] == '*' or stack[-1] == '/'):
                res+=stack.pop()
            stack.append(i)
        elif i=='+' or i=='-':
            while stack and stack[-1] != '(' :
                res+=stack.pop()
            stack.append(i)
        elif i ==')':
            while stack and stack[-1] !='(' :
                res+=stack.pop()
            stack.pop()
while stack:
    res+=stack.pop()
print(res)

