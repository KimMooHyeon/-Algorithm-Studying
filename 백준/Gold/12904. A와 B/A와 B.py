import sys

firstString = list(sys.stdin.readline().rstrip())
secondString = list(sys.stdin.readline().rstrip())
changeFlag = True

while True:
    if len(firstString) == len(secondString):
        if firstString == secondString:
            print(1)
        else:
            print(0)
        break

    if secondString[-1] == "A":
        secondString.pop()

    else:
        secondString.pop()
        secondString.reverse()
