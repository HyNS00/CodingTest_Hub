import sys
input =sys.stdin.readline

n,m = map(int,input().split())
heavy = [[] for _ in range(n+1)]
light = [[] for _ in range(n+1)]

# b가 a보다 크다, heavy  a가 b보다 작다 light
for _ in range(m):
    a,b = map(int,input().split())
    heavy[b].append(a)
    light[a].append(b)

mid = (n+1) // 2


def dfs(arr,start):
    global check

    visited[start] = True
    for i in arr[start]:
        if not visited[i]:
            check += 1
            dfs(arr,i)

count = 0
for i in range(1, n+1):
    visited =[False] *(n+1)
    check =0 
    
    dfs(heavy,i)
    if check >= mid:
        count += 1

    check =0
    visited =[False] *(n+1)
    dfs(light,i)
    if check >= mid:
        count += 1

print(count)