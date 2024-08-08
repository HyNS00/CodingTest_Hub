import java.util.Deque;
import java.util.ArrayDeque;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int m = board.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int j : moves){
            int i = 0;
            while(i < m){
                int doll = board[i][j-1];
                if(doll > 0){
                    if(!stack.isEmpty() && stack.peek() == doll){
                        stack.pop();
                        answer +=2;
                    }else{
                        stack.push(doll);
                    }
                    board[i][j-1] = 0;
                    break;
                }else{
                    i++;
                }
            }
        }
        return answer;
    }
}