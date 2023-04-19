import sys
input = sys.stdin.readline

N,K = map(int,input().split())
numbers = list(input())
stack = []
L = N-K
for number in numbers:
    while stack and stack[-1] < number and K > 0:
        stack.pop()
        K -= 1
    stack.append(number)
for i in range(L):    
    print(''.join(stack[i]),end ='')
