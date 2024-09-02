class Solution {
    public int solution(int n, int m, int[] section) {
        int[] sections = new int[n];
        for(int num : section){
            sections[num-1] = 1;
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(sections[i] == 1){
                cnt++;
                for(int j = i; j < Math.min(i+m,n); j++){
                    sections[j] = 0;
                }
                i = Math.min(i+m-1, n-1);
            }
        }
        return cnt;
    }
}