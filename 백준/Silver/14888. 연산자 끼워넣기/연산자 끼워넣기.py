import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n = int(input())
data = list(map(int,input().split()))
cal = list(map(int,input().split()))
max_v = -1e9
min_v = 1e9
def dfs(i, plus,sub,mul,div,total):
    global min_v, max_v
    if i == n:

        max_v= max(max_v,total)
        min_v = min(min_v, total)

    else:
        if plus:
            dfs(i+1, plus -1, sub,mul,div,total + data[i])

        if sub :
            dfs(i+1, plus,sub-1,mul,div,total -data[i])

        if mul:
            dfs(i+1, plus,sub,mul-1,div,total * data[i])

        if div :
            dfs(i+1,plus,sub,mul,div-1,int(total / data[i]))

dfs(1, cal[0],cal[1],cal[2],cal[3],data[0])
print(max_v)
print(min_v)