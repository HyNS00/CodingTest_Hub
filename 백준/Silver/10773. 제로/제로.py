import sys

input = sys.stdin.readline
k = int(input())

stack = []
for i in range(k):
    a = int(input())
    if a == 0 and len(stack) != 0:
        stack.pop()

    else :
        stack.append(a)

print(sum(stack))