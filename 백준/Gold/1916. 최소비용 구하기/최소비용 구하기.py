import sys, heapq
input = sys.stdin.readline
n = int(input())
m = int(input())
INF = int(1e9)
graph = [[] for i in range(n+1)] # graph와 distance를 n+1로 받는게 중요
distance = [INF] * (n+1)

for _ in range(m):          #이걸 m을 하는게 중요
    a,b,c = map(int,input().split())
    graph[a].append((b,c))  # 도착지, 가중치
start, end = map(int,input().split())

def dijkstra(graph,start):
    distance =[INF] *(n+1)
    distance[start] = 0
    q = []
    heapq.heappush(q,[distance[start],start]) # 시작노드 탐색 (값, now)
    
    while q:
        dist,node =heapq.heappop(q)

        if distance[node] < dist:
            continue

        for next_node, next_dist in graph[node]:
            new_distance = dist + next_dist # 다음 노드까지의 거리
            if new_distance < distance[next_node] :
                distance[next_node] = new_distance
                heapq.heappush(q, [new_distance, next_node]) # 다음 인접 거리 계산을 위한 삽입

    return distance

dist_start = dijkstra(graph,start)
print(dist_start[end])
