import sys
from collections import deque
input = sys.stdin.readline
N,M,V = map(int,input().split())
graph = [[] for _ in range(N+1)]   #  [[], [2 ,3,4],[4],[4]]
for _ in range(M):
   x,y = map(int,input().split())
   graph[x].append(y)
   graph[y].append(x)
for i in range(1, N+1):
    graph[i].sort()
visited1 = [False] * (N+1)
visited2 = [False] * (N+1)
# BFS
def bfs(graph,start,visited):
    queue = deque([start])

    visited[start] = True

    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
# DFS
def dfs(graph,start, visited):

    visited[start] = True
    print(start, end= ' ')
    for i in graph[start]:
        if not visited[i]:
            dfs(graph,i,visited)

dfs(graph,V,visited1)
print()
bfs(graph,V,visited2)