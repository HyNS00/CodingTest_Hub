from collections import deque
import sys
input = sys.stdin.readline
result = []
N,K = map(int,input().split())
solve = deque(range(1,N+1))

while solve :
    for i in range(K-1):
        solve.append(solve.popleft())
    result.append(solve.popleft())   # 머릿속으로 생각한 것으로 구현할 줄 알아야한다.

print('<{}>'.format(', '.join(map(str,result))))

