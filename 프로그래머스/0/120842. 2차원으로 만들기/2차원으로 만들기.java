class Solution {
    public int[][] solution(int[] num_list, int n) {
        int total = num_list.length;
        int m = total / n;
        int[][] answer = new int[m][n];
        int ele = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                answer[i][j] = num_list[ele++];
            }
        }
        return answer;
    }
}