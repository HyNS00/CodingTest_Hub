import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int,input().split())
coins = []
visited = [0] * (k+1) # 방문할 시 1, 아닐 시 0
for _ in range(n):
    coin = int(input())
    coins.append(coin)

arr =[[] for _ in range(k+1)]
q = deque()
# count,coin을 append해주는 것이 중요
# coin에서 1과 함께 동전을 담는 경우우
for coin in coins:
    if coin > k:
        continue
    q.append((coin,1))
    visited[coin] = 1
flag= False # bfs를 다 돌고 나서도 False면 해당 합을 만들 수 없으므로 -1 출력

while q:
    val,cnt = q.popleft()
    if val ==  k:
        print(cnt)
        flag = True
        break
   # coin하나를 뽑아서, val을 만들고, 처리 
    for coin in coins:
        if val + coin > k:
            continue
        # 앞에 if문 조건을 걸어줌으로써 val+coin <= k인 조건을 안 써줘도 된다.
        if visited[val+coin] == 0:
            q.append((val+coin,cnt+1))
            visited[val+coin]  = 1


if not flag:
    print(-1)