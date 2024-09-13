import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        LinkedList<Integer> stack = new LinkedList<>();
        int answer = 0;
        for(int i : ingredient){
            stack.push(i);
            int n = stack.size();
            if(n >= 4){
                if(stack.get(0) == 1 && stack.get(1) == 3
                  && stack.get(2) == 2 && stack.get(3) == 1){
                    answer++;
                    for(int j = 0; j < 4; j++){
                        stack.pop();
                    }
                }
            }
        }
        return answer;
    }
}