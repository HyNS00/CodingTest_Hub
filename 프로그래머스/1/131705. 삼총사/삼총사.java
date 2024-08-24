class Solution {
    int cnt = 0;
    
    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        func(number,visited, 0,3);
        return cnt;
    }
    public void func(int[] number, boolean[] visited, int start, int round){
        if(round == 0){
            int sum = 0;
            for(int i = 0; i < number.length; i++){
                if(visited[i]){
                    sum += number[i];
                }
            }
            if(sum == 0){
                cnt++;
            }
            return;
        }
        for(int i = start; i < number.length; i++){
            visited[i] = true;
            func(number,visited,i+1,round-1);
            visited[i] = false;
        }
    }
}