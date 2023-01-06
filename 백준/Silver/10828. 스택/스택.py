import sys
input=sys.stdin.readline
class Stack:
    def __init__(self):
        self.stack=[]

    def isEmpty(self):
        if len(self.stack) == 0:
            print(1)
            return True
        else:
            print(0)
            return False

    def push (self,data):
        self.stack.append(data)

    def pop(self):
        if len(self.stack) == 0:
            print(-1)
        else:
            print(self.stack.pop())

    def size(self):
        print(len(self.stack))

    def top(self):
        if len(self.stack) == 0:
            print(-1)
        else:
            print(self.stack[-1])



n=int(input())

stack=Stack()
for i in range(n):
    a=list(input().split())
    if a[0]=='push':
        stack.push(a[1])
    else:
        if a[0]=='pop':
            stack.pop()
        elif a[0]=='empty':
            stack.isEmpty()
        elif a[0]=='size':
            stack.size()
        elif a[0]=='top':
            stack.top()

