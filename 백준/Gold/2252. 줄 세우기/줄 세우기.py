
import sys
from collections import deque
input =sys.stdin.readline

n,m = map(int,input().split())
graph =[[] for _ in range(n+1)]
indegree =[0] *(n+1)

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    indegree[b] += 1

def pro():
    result = []
    q = deque()
    for i in range(1,n+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        result.append(now)
        for j in graph[now]:
            indegree[j] -= 1
            if indegree[j] == 0:
                q.append(j)
    
    for i in result:
        print(i, end = ' ')

pro()