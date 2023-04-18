import sys, heapq
input = sys.stdin.readline

N = int(input()) 
# 왼쪽과 오른쪽을 나누는 것이 핵심 포인트
left_heap = []
right_heap = []

for _ in range(N):
    num = int(input())

    if len(left_heap) == len(right_heap):
        heapq.heappush(left_heap, -(num))

    else :
        heapq.heappush(right_heap, num)

    # [1,2,8] [3,4,6] 일 경우  3과 8을 바꿔주는 역할
    if right_heap and left_heap and -left_heap[0] > right_heap[0] :
        a = heapq.heappop(left_heap)
        b = heapq.heappop(right_heap)

        heapq.heappush(left_heap,-b)
        heapq.heappush(right_heap,-a)

    
    print(-left_heap[0]) 