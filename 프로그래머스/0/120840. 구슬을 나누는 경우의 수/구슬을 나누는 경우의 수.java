class Solution {
    public long solution(int balls, int share) {
        // 오버플로우 대비
        // long을 사용해준다.
        // 조합의 분자는 n .. n-m+1 까지의 곱셈
        // 분모는 m!
        long answer = 1;
        for(int i = 1; i <= share; i++){
            answer = answer * (balls-share+i)/i;
        }
        return answer;
    }
}