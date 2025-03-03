import java.util.*;
import java.util.stream.*;
class Solution {
    private Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        for(int i = 1; i <= numbers.length(); i++){
            boolean[] visited = new boolean[numbers.length()];
            permutation(visited, 0, i, "", numbers);
        }
        int answer = (int) set.stream().filter(this::check)
            .count();
        return answer;
    }
    private void permutation(boolean[] visited, int depth, int checker, String curr, String numbers){
        if(depth == checker){
            set.add(Integer.parseInt(curr));
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(visited,depth+1,checker,curr + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    private boolean check(int num){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(int i = 3; i <= Math.sqrt(num); i += 2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}