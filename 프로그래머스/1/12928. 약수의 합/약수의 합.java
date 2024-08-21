class Solution {
    public int solution(int n) {
        int i = 1;
        int sum = 0;
        while(i <= n){
            if(n % i == 0){
                sum+= i;
            }
            i++;
        }
        return sum;
    }
}