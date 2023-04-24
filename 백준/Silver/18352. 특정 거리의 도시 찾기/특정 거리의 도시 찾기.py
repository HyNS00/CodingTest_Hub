import sys
input =sys.stdin.readline
from collections import deque
N,M,K,X =map(int,input().split())
graph =[[] for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,input().split())
    graph[a].append(b)
visited =[False] * (N+1)
distance =[0] *(N+1)
answer = []
def bfs(start):
    queue = deque([start])
    visited[start] = True
    distance[start] = 0
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                distance[i] = distance[v] + 1  # 방문하지 않았을 경우. 방문처리하고 
                if distance[i] == K:           # 그 위치까지의 거리를 +1 해준다.
                    answer.append(i)
    if len(answer) == 0:
        print(-1)

    else:
        answer.sort()
        for i in answer:
            print(i, end ='\n')

bfs(X)