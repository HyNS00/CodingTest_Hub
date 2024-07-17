class Solution {
    public int solution(int[] array, int height) {
        int cnt = 0;
        for(int num : array){
            if(num > height){
                cnt++;
            }
        }
        return cnt;
    }
}