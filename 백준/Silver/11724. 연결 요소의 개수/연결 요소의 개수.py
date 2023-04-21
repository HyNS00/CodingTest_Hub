import sys
from collections import deque
input =sys.stdin.readline

N,M = map(int,input().split())
graph =[[] for _ in range(N+1)]
for _ in range(M):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

cnt =0
visited = [False] * (N+1)

def bfs(graph,start,visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


for i in range(1,N+1):
    if visited[i]:
        continue
    bfs(graph,i,visited)
    cnt += 1

print(cnt)