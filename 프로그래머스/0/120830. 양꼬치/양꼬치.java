class Solution {
    public int solution(int n, int k) {
        // 10 -> 음료수 하나를 서비스로 준다.
        int service = n / 10;
        int answer = n * 12000 + (k - service) * 2000;
        return answer;
    }
}