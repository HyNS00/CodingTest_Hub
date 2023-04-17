
import sys
input = sys.stdin.readline
n = int(input())
stack = []
for i in range(n):
    commend = input().split()  # 숫자가 아니라 이렇게 그냥 받으면 리스트로 자동으로 받음

    if commend[0] == 'push':
        stack.append(int(commend[1]))

    elif commend[0] == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())
    elif commend[0] == 'size':
        print(len(stack))

    elif commend[0] == 'empty':
        
        if len(stack) == 0:
            print(1)
        else :
            print(0)

    elif commend[0] == 'top':

        if len(stack) == 0:
            print(-1)
        else :
            print(stack[-1])
    