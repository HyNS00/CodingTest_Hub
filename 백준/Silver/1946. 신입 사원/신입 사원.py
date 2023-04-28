
import sys
input = sys.stdin.readline

test_case =int(input())


for _ in range(test_case):
    n = int(input())
    new = []
    for _ in range(n):
        a,b = map(int,input().split())
        new.append((a,b))
    # 오름차순으로 정렬 점수 서류
    new = sorted(new,key = lambda x : x[0])
    test = new[0][1] # 서류 점수 1위의 면접순위
    cnt = 1 # 합격

    for i in range(1,n):
        if  test > new[i][1] :
            test = new[i][1]
            cnt += 1
    print(cnt)
