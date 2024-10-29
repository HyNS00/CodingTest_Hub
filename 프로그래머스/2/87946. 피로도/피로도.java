class Solution {
    private int answer = 0;
    private boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return answer;
    }
    private void dfs(int cnt, int fatigue, int[][] dg){
        for(int i = 0; i < dg.length; i++){
            if(visited[i] || fatigue < dg[i][0]) continue;
            visited[i] = true;
            dfs(cnt+1, fatigue - dg[i][1], dg);
            visited[i] = false;
        }
        answer = Math.max(answer, cnt);
    }
}