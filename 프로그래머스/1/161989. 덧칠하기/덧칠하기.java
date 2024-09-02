class Solution {
    public int solution(int n, int m, int[] section) {
        int cnt = 0;
        int covered = 0;
        for(int i : section){
            if(i > covered){
                cnt++;
                covered = i + m-1;
            }
            if(covered > n){
                covered = n;
            }
        }
        return cnt;
    }
}