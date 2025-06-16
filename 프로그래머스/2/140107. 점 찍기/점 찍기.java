
class Solution {
    public long solution(int k, int d) {
        long cnt = 0;
        for(int x = 0;  x <= d; x+=k){
            int result = 0;
            int left = 0;
            int right = d;
            while(left <= right){
                int mid = (left + right) / 2;
                long tmp = (long) d * d - (long) x*x;
                if(tmp - (long) mid * mid >= 0){
                    result = mid;
                    left = mid+1;
                }else {
                    right = mid -1;
                }
            }
            cnt += (long) result / k + 1;
        }
        return cnt;
    }
    // 제한된 범위 내에서 가장 큰 값을 찾아내고 그 값을 줄여본다.
}