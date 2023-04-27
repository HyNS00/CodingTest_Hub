import sys
input = sys.stdin.readline

n = int(input())
graph = []
vistited = [[0] * n for _ in range(n)]
for _ in range(n):
    k = list(map(int,input().strip()))
    graph.append(k)
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def dfs():
    global apart
    # 해야할게 뭐가 있을까? 아마 그래프를 전체 돌면서 0이 아닌 1을 찾아야겠지?
    # dfs를 사용해야하니까 stack을 사용해야겠지??
    stack = []
    value = 0
    apart = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1 and vistited[i][j] == 0:
                stack.append((i,j)) # stack에 넣은 다음 다시 진행?
                vistited[i][j] = 1 # 방문처리를 한다.
                value += 1  # 다른 1을 만나면 , value증가
                house = 1

                while stack:
                    x,y = stack.pop()
                    for p in  range(4):
                        nx = x+dx[p]
                        ny = y+dy[p]
                        
                        if 0 <= nx < n and 0 <= ny < n and vistited[nx][ny] == 0 and graph[nx][ny] == 1:
                            stack.append((nx,ny))
                            vistited[nx][ny] = 1
                            house += 1

                apart.append(house)  # while을 벗어나면 1추가
    return value

print(dfs())
apart.sort()
for i in apart:
    print(i)