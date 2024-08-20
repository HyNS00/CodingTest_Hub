class Solution {
    public int solution(int n) {
        // 숫자를 하나받아서 매번 체크 
        int cnt = 2;
        while(n > cnt){
            if(n % cnt == 1){
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }
}