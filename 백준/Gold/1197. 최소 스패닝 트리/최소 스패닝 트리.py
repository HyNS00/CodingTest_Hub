import sys
input = sys.stdin.readline

V,N = map(int,input().split())

# 크루스칼 알고리즘
edges = []
for _ in range(N):
    A,B,C = map(int,input().split())
    edges.append((A,B,C))

edges.sort(key = lambda x : x[2])  #cost가 작은걸로 정렬

# union - find
parent =[ i for i in range(V+1)]

def get_parent(x):
    if parent[x] == x:
        return x
    
    parent[x] = get_parent(parent[x])
    return parent[x]

def union_parent(a,b):
    a = get_parent(a)
    b = get_parent(b)

    if a < b : 
        parent[b] = a

    else:
        parent[a] = b

def same_parent(a,b):
    return get_parent(a) == get_parent(b)

answer = 0
for a,b,cost in edges:
    # cost가 작은 edge부터 하나씩 추가해가면서 같은 부모를 공유하지 않을 때(사이클 없을 때만)만 확정
    if not same_parent(a,b):
        union_parent(a,b)
        answer += cost
print(answer)