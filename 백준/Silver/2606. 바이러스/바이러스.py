import sys
input = sys.stdin.readline
N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
visited = [False] * (N+1)
cnt = 0
def dfs(graph,start,visited) :
    global cnt
    visited[start] = True
    for i in graph[start]:
        if  not visited[i]:
            dfs(graph,i,visited)
            cnt +=1
dfs(graph,1,visited)
print(cnt)