import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

K = int(input())

def dfs(v,group):
    visited[v] = group #방문한 노드에 group할당
    for i in graph[v]:
        if not visited[i]: # 아직 방문하지 않았다면 // False일 때 실행
            if not dfs(i, -group):
                return False
            
        elif visited[i] == visited[v]: # 방문한 곳인데, 그룹이 동일하면 False
            return False
    # print(group)    
    return True

for _ in range(K):
    V,E = map(int,input().split())
    graph =[[] for i in  range(V+1)]
    visited = [False] * (V+1)
    for _ in  range(E):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
        # 무방향 그래프

    flag = True
    for i in range(1,V+1):
        if not visited[i]:
            flag = dfs(i,1)
            if not flag:
                break

    print('YES' if flag else 'NO')