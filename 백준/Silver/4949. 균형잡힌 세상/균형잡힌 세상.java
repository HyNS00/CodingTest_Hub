
import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String tmp = br.readLine();

            if (tmp.equals(".")) {
                break;
            }
            checker(tmp);
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
    private static void checker(String tmp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean flag = true;
        for (char c : tmp.toCharArray()) {
            if(c == '(' || c == '[') {
                stack.push(c);
            }
            if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }
                stack.pop();
            }
            if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!flag || !stack.isEmpty()) {
            sb.append("no").append("\n");
        }else {
            sb.append("yes").append("\n");
        }
    }
}
