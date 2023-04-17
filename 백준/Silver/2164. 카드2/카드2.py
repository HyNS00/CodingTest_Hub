
from collections import deque
import sys
input = sys.stdin.readline

N = int(input())

stack = deque([i+1 for i in range(N)])

while len(stack) > 1:
    stack.popleft()
    num = stack.popleft()
    stack.append(num)

print(stack[0])
