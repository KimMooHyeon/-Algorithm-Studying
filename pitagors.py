
for a in range(1, 1001):
    for b in range(1, 1001 - a):
         if a*a + b*b == (1000-a-b)**2 and a<b<1000-a-b:
             print(a*b*(1000-a-b))



