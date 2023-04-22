import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)
N = int(input())
graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)
parent =[0] * (N+1)

def dfs(node):
    visited[node] = True
    for i in graph[node]:
        if not visited[i]:
            parent[i] = node
            dfs(i)


while True:
    try :
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)

    except :
        break

dfs(1)

print(*parent[2:],sep= '\n')