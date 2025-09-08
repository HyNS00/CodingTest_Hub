
import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        char[] s = br.readLine().toCharArray();

        int result = checker(s, n, m);
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
    private static int checker(char[] target, int n, int m) {
        int cnt = 0;
        ArrayDeque<Character> stack  = new ArrayDeque<>();
        int standard = 2 * n + 1;
        for(int i = 0; i <= m - standard; i++) {
            if(target[i] != 'I') continue;
            stack.push(target[i]);
            for(int j = i+1; j < i + standard; j++){
                if(!stack.isEmpty() && stack.peek() != target[j]) {
                    stack.push(target[j]);
                }else {
                    break;
                }
            }
            if(stack.size() == standard) cnt++;
            stack.clear();
        }

        return cnt;
    }
}
