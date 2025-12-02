
import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(c >= 'A' && c <= 'Z') sb.append(c);
            else  if(c == '(') stack.push(c);
            else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // ( 이걸 빼야 한다.
            } else {
                while(!stack.isEmpty() && order(stack.peek()) >= order(c)){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int order(char c) {
        if(c == '*' || c == '/') return 2;
        if(c == '-' || c == '+') return 1;

        if(c == '(') return 0;

        return -1;

    }
}
