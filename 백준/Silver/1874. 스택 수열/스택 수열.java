import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int value = 1;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input >= value) {
                while (value <= input) {
                    stack.push(value);
                    sb.append("+").append("\n");
                    value++; // 하나 넣었으니 다음 숫자로 증가
                }
            }
            if(!stack.isEmpty() && input == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
            }else {
                bw.write("NO");
                bw.close();
                br.close();
                return;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
