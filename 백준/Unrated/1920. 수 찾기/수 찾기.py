import sys
input = sys.stdin.readline

N = int(input())
N_list =list(map(int,input().split()))

M = int(input())
M_list = list(map(int,input().split()))

N_list.sort()

def binary(array,target, start, end):
   
    while start <= end :
        mid = (start+end) //2

        if array[mid] == target :
            return True
        
        elif  array[mid] > target:
            end = mid -1

        else :
            start = mid+1
    return None

for i in M_list :
    if binary(N_list,i,0, N-1) :
        print('1')
    else:
        print('0')