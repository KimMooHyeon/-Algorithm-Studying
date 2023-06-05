def change(num):
    return sum(list(map(int, num.split("+"))))


answer = 0
n = list(input().rstrip())
zero = 0
one = 0
start = n[0]
if n[0] == "0":
    zero += 1
else:
    one += 1
for i in range(1, len(n)):
    if start != n[i]:
        start = n[i]
        if n[i] == "0":
            zero += 1
        else:
            one += 1

print(min(zero, one))
