import sys

input = sys.stdin.readline
N = int(input())

liquid = list(map(int,input().split()))

liquid.sort()
left =0
right =N-1
total = sys.maxsize
answer = [liquid[left] , liquid[right]]
while left < right :
    N_left = liquid[left]
    N_right = liquid[right]

    if N_left + N_right == 0 :
        answer=[N_left,N_right]
        break
    
    elif N_left + N_right < 0:
        left += 1

    else :
        right -= 1

    if abs(N_left+ N_right) < total :
        total = abs(N_left+ N_right)
        answer=[N_left,N_right]


print(answer[0], answer[1])
