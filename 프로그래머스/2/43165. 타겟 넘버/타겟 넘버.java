class Solution {
    private int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return cnt;
    }
    private void dfs(int[] numbers, int target, int idx, int currSum){
        if(idx == numbers.length){
            if(currSum == target){
                cnt++;            
            }
            return;
        }
        dfs(numbers,target,idx+1,currSum + numbers[idx]);
        dfs(numbers,target,idx+1,currSum - numbers[idx]);
    }
}