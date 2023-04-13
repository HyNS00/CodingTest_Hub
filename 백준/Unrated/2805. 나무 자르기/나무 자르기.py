import sys
input = sys.stdin.readline

N,M = map(int,input().split())

h =list(map(int,input().split()))



start = 0
end = max(h)

while start <= end :
    total = 0
     
    mid = (start+ end) //2 # mid는 가져갈 나무의 높이

    for x in h :
        if x > mid :
            total += x-mid

    if total < M :
        end = mid -1
    else :
        result = mid  # mid에 저장함으로써 최대한 값을 보존
        start = mid+1

print(result)
