import sys

input = sys.stdin.readline
N = int(input())

tower = list(map(int,input().split()))

# stack을 잘 이용해야한다.
# stack개념을 이용하는게 아니라 그 자체, 즉 쌓는 과정을 만들어서 사용하는 것이 idea
# result, stack을 이용할 리스트를 만들어놓고 하나씩 넣는다.

stack = []
result = []
for i in range(N):
    while stack:    # stack이 있다면, result에 추가
        if stack[-1][1] >= tower[i]:
            result.append(stack[-1][0]+1)   # 수신받음을 의미
            break

        else :
            stack.pop()

    if len(stack) == 0 :   # stack이 비어있다면 0을 추가한다.
        result.append(0)   # 받을게 없다

    stack.append((i,tower[i]))  # 스택에 추가

for i in result :
    print(i, end= ' ')