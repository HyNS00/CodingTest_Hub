import java.util.*;
class Solution {
    static List<List<Integer>> list;
    public int solution(int n, int[][] q, int[] ans) {
        list = new ArrayList<>();
        for(int i = 1; i <= n-4; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(i);
            dfs(curr,1,i,n);
        }
        int answer = 0;
        for(List<Integer> target : list) {
            if(checker(q,ans,target)) {
                answer++;
            }
        }
        return answer;
    }
    private boolean checker(int[][] q, int[] ans, List<Integer> target) {
        for(int i = 0; i < q.length; i++) {
            int[] tmp = q[i];
            
            int cnt = 0;
            
            for(int j = 0; j < 5; j++) {
                if(target.contains(tmp[j])) {
                    cnt++;
                }
            }
            if(ans[i] != cnt) {
                return false;
            }
        }
        return true;
    }
    private void dfs(List<Integer> curr, int depth, int start, int n) {
        if(depth == 5) {
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start+1; i <= n; i++) {
            curr.add(i);
            dfs(curr, depth+1, i, n);
            curr.remove(curr.size()-1);
        }
        
    }
}