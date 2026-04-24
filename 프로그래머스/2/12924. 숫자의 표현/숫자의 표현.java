class Solution {
    public int solution(int n) {
        int cnt = 0;
        int start = 1;
        int end = 1;
        int sum = 1;
        
        while(start <= n) {
            if(sum == n) {
                cnt++;
                sum -= start;
                start++;
            }else if(sum > n) {
                sum -= start;
                start++;
                
            }else {
                end++;
                sum += end;
            }
        }
        return cnt;
    }
}