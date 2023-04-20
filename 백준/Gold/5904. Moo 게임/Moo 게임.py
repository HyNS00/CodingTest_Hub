import sys
input = sys.stdin.readline
N = int(input())
def repeat(total,mid, N):
    if N <= 3:
        return 'moo'[N-1]
    
    left = (total - mid) // 2
    if N <= left:
        return repeat(left,mid -1,N)
    
    elif N >= left+mid:
        return repeat(left,mid-1,N-left-mid)
    
    elif N - left == 1:
        return 'm'
    else:
        return 'o'
    
total =3
n = 0
while total < N:
    n += 1
    total = 2*total +n +3
print(repeat(total,n+3,N))