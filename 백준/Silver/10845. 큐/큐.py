import sys
input=sys.stdin.readline

class Queue:
    def __init__(self):
        self.queue=[]

    def push(self,data):
        self.queue.append(data)

    def pop(self):
        if len(self.queue) == 0:
            print(-1)
        else:
            poped=self.queue[0]
            self.queue=self.queue[1:]
            print(poped)
    def size(self):
        print(len(self.queue))
    def empty(self):
        if len(self.queue) == 0:
            print(1)
        else:
            print(0)
    def front(self):
        if len(self.queue) == 0:
            print(-1)
        else:
            fronted=self.queue[0]
            print(fronted)
    def back(self):
        if len(self.queue) == 0:
            print(-1)
        else:
            backed=self.queue[-1]
            print(backed)

n=int(input())

queue=Queue()
for i in range(n):
    a=list(input().split())
    if a[0]=='push':
        queue.push(a[1])
    else:
        if a[0]=='pop':
            queue.pop()
        elif a[0]=='empty':
            queue.empty()
        elif a[0]=='size':
            queue.size()

        elif a[0]=='front':
            queue.front()
        elif a[0]=='back':
            queue.back()
