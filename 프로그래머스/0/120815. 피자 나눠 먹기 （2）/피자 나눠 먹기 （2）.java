class Solution {
    public int solution(int n) {
        // 6 * cnt 를 하면서 n
        // 진짜 무식
        int cnt = 1;
        while((6*cnt) % n  != 0){
            cnt++;
        }
        return cnt;
    }
}