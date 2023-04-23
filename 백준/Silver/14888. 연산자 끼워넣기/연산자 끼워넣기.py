import sys
input =sys.stdin.readline
sys.setrecursionlimit(10**9)
N = int(input())
N_list = list(map(int,input().split()))

add,sub,mul,div = map(int,input().split())
min_value = 1e9
max_value = -1e9


def cal(i,arr):
    global  add,sub,mul,div,min_value,max_value
    if i == N:
        max_value = max(max_value, arr)
        min_value = min(min_value,arr)

    else :
        if add > 0 :
            add -= 1
            cal(i+1, arr+ N_list[i]) 
            add += 1

        if sub > 0:
            sub -= 1
            cal(i+1,arr-N_list[i])
            sub += 1

        if mul > 0:
            mul -= 1
            cal(i+1,arr * N_list[i])
            mul += 1

        if div > 0:
            div  -= 1
            cal(i+1,int(arr/ N_list[i]))
            div += 1

cal(1, N_list[0])
print(max_value)
print(min_value)