import sys
input =sys.stdin.readline

N = int(input())
tree ={}
# root를 key로 / left,right 자식들을 value로 할당
# tree[root] = left,right
'''
{"A":("B","C")}
이제 B를 인덱싱하는 것은 tree['A'][0]
'''


'''
한번 재귀할 때 마다 탐색을 한번 더 하는 의미
함수 안의 ~~order(tree[root][0])재귀함수는 왼쪽으로 끝까지 탐색
함수 안의 ~~order(tree[root][1])재귀함수는 오른쪽 끝까지 탐색

'''
for n in range(N):
    root,left,right = input().strip().split()
    tree[root] =[left,right]

# 전위 = 루트 -> 왼쪽 -> 오른쪽
def preorder(root):
    if root != '.':
        print(root,end ='')
        preorder(tree[root][0])
        preorder(tree[root][1])

# 중위 = 왼쪽 -> 루트 -> 오른쪽
def inorder(root):
    if root != '.':
        inorder(tree[root][0]) #left
        print(root, end ='') # 루트
        inorder(tree[root][1]) #오른쪽
# 후위 = 왼쪽 -> 오른쪽 -> 루트
def postorder(root):
    if root != '.':
        postorder(tree[root][0]) #left
        postorder(tree[root][1]) #right
        print(root,end='') # root

preorder('A')
print()
inorder('A')
print()
postorder('A')
