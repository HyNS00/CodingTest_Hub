n, m = map(int,input().split())
room = []
for _ in range(n):
    a = list(input())
    room.append(a)

visited =[[0] * m for _ in range(n)]

dx =[-1,1]
dy =[-1,1]
'''
'''
def dfs(x,y):
    if room[x][y] == '-':
        visited[x][y] = 1
        for j in dy:
            ny = y + j
            if 0 <= ny < m and  visited[x][ny] == 0 and room[x][ny] == '-':
                dfs(x,ny)
# y에서  + -1 을 계속 해야한다
# x는 같다
    elif room[x][y] =='|' :
        visited[x][y] = 1
        for i in dx:
            nx = x + i
            if 0 <= nx < n and visited[nx][y] == 0 and room[nx][y] =='|':
                dfs(nx,y)

cnt = 0
for i in range(n):
    for j in range(m):
        if visited[i][j] == 0:
            dfs(i,j)
            cnt +=1
print(cnt)