class Solution {
    public int solution(int[] numbers, int k) {
        // 1 2 3 4 -> 
        int cnt = 1;
        int i = 0;
        while(cnt < k){
            cnt++;
            i +=2;
            if(cnt == k){
                break;
            }
        }
        if(i >= numbers.length){
            return numbers[i % numbers.length];
        }
        else{
            return numbers[i];
        }
    }
}