class Solution {
    public int solution(int n) {
        long[] arr = new long[n+1];
        if(n <= 2){
            return n;
        }
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
        }
        return (int)arr[n];
    }
    
}