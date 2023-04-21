import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline
nums = []
while True:
    try :
        nums.append(int(input()))

    except:
        break

# nums의 시작 start 인덱스
# nums의 끝 인덱스 end

def post(start, end):
    if start == end: # start와 end가 같은 경우
        # 한가지 경우만 있으니 출력
        print(nums[start])
        return
    root = nums[start]
    mid = start
    for i in range(start+1,end+1):
        if nums[i] > root: # 왼쪽 서브트리와 오른쪽 서브트리 구분을 위한 작업
            mid = i
            break

    if mid == start + 1 or mid == start: # 왼쪽 자식이 없거나 오른쪽 자식이 없으면
        post(start+1, end)
    else:
        post(start+1,mid-1) #왼쪽 서브 트리 실행
        post(mid,end)

    print(root)

post(0,len(nums)-1)
