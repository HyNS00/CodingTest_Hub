import sys
'''
x = 공유기 사이 거리


'''
input = sys.stdin.readline

N,wifi = map(int,input().split())
house = []
for _ in range(N) :
    house.append(int(input()))

house.sort()
start = 1 # 최소거리
end = house[-1] - house[0]

result = 0
while (start <= end):
    mid = (start + end) // 2
    value = house[0] # 현재 위치
    cnt = 1
    for i in range(1,N) :
        if house[i] >= value +mid :
            value = house[i]
            cnt += 1
            
    if cnt >= wifi:
        start = mid +1
        result = mid

    else :
        end = mid - 1

print(result)
