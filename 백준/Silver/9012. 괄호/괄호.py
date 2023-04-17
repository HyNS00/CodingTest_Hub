import sys

input = sys.stdin.readline
n = int(input())


for j in range(n):
    stack =[]
    vps = input().rstrip()
    for i in vps :
        if i =='(' :
            stack.append('(')
        
        elif i == ')':
            if stack:  # stack안에 값이 존재한다면 
                stack.pop()
            else:
                stack.append(')')
                break
    if len(stack) == 0:
        print('YES')
    else :
        print('NO') 