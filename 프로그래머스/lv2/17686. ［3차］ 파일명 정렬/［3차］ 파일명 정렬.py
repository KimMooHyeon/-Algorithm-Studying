def divide(file):
    head = ""
    number = ""
    tail = ""
    process = 0
    for i in file:
        if process == 0:
            if not('0' <= i <= '9'):
                head += i
            else:
                process = 1
                number += i
        elif process == 1:
            if '0' <= i <= '9':
                number += i
            else:
                process = 2
                tail += i
        else:
            tail += i
    return [head, number, tail]


def solution(files):
    answer = []
    fileList = []
    for i in range(0, len(files)):
        fileList.append((i, divide(files[i])))

    fileList.sort(key=lambda x: (x[1][0].upper(),int(x[1][1]),x[0]))
 
    for list in fileList :
        answer.append("".join(list[1]))
    return answer
