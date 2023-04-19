import sys
import heapq

input = sys.stdin.readline

tmp_list_line = []
list_line = []

num = int(input())
check_cnt = [0] * num

for _ in range(num):
    x = list(map(int,input().split()))
    x.sort()
    tmp_list_line.append(x)

red_line = int(input())

for i in range(num):
    if tmp_list_line[i][1] - tmp_list_line[i][0] > red_line:
        continue
    list_line.append(tmp_list_line[i])

list_line.sort(key = lambda x : (-x[0]))

stack = []

answer = 0

for i in range(len(list_line)):
    if not stack:
        heapq.heappush(stack,-1 * list_line[i][1])
    else:
        while stack:
            if list_line[i][0] + red_line < -1 * stack[0]:
                heapq.heappop(stack)
            else:
                break
        heapq.heappush(stack, -1 * list_line[i][1])
    answer = max(answer,len(stack))

print(answer)