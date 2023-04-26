import sys
input = sys.stdin.readline

sys.setrecursionlimit(10**3)
# 빙산이외에 바다에 해당하는 칸은 0
# 그 외의 높이는 빙산의 정보
graph = []
r,c = map(int,input().split())
for _ in range(r):
    a = list(map(int,input().split()))
    graph.append(a)
dx =[-1,1,0,0]
dy =[0,0,-1,1]


def melting():
    change = []
    for i in range(1,r-1):
        for j in range(1,c-1):
            if graph[i][j] != 0:
                sea = 0
                for k in range(4):
                    nx = i+dx[k]
                    ny = j+dy[k]
                    if 0 <= nx < r and 0 <= ny < c and graph[nx][ny] == 0:
                        sea += 1

                if graph[i][j] - sea  > 0:
                    graph[i][j] = graph[i][j] -sea

                else:
                    change.append((i,j))

    for x,y in change:
         graph[x][y] = 0

def dfs(s,e):
    visited[s][e] = 1
    stack =[(s,e)]
    while stack :
        xx,yy =stack.pop()
        for i in range(4):
            nx = xx+dx[i]
            ny = yy+ dy[i]
            if 0 <= nx < r and 0 <= ny < c and visited[nx][ny] == 0 and graph[nx][ny] != 0:
                visited[nx][ny] = 1
                stack.append((nx,ny))

day =0
while True :
    visited =[[0] * c for _ in range(r)]
    count = 0
    for i in range(1,r-1):
        for j in range(1,c-1):
            if graph[i][j] != 0 and visited[i][j] == 0:
                dfs(i,j)
                count += 1
    if count > 1:
        print(day)
        break
    elif count == 0:
        print(0)
        break
    melting()
    day += 1