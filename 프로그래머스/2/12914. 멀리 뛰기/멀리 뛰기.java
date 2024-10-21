class Solution {
    public long solution(int n) {
        // 총 1칸 또는 2칸
        if(n <= 2){
            return n;
        }
        int[] answer = new int[n+1];
        answer[2] = 2;
        answer[1] = 1;
        for(int i = 3; i <= n; i++){
            answer[i] = (answer[i-1]+answer[i-2]) % 1234567;
        }
        return (long) answer[n];
    }
}