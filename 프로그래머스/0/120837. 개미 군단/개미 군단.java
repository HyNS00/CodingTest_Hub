class Solution {
    public int solution(int hp) {
        // else의 유무도 중요하다.
        int cnt = 0;
        if(hp >= 5){
            cnt += hp/5;
            hp %= 5;
        }
        if(hp >= 3){
            cnt += hp /3;
            hp %= 3;
        } 
        
        cnt += hp; // 나머지 다 더하기
        
        return cnt;
    }
}