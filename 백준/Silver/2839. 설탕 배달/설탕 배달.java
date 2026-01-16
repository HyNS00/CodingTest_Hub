
import java.io.*;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        cnt = 0;
        cheker(n);
        bw.write(String.valueOf(cnt));

        bw.close();
        br.close();
    }
    static void cheker(int n) {
        while(true) {
            if(n % 5 == 0) {
                cnt += (n/5);
                return;
            } else {
                n-= 3;
                cnt++;
            }
            if(n < 0) {
                cnt = -1;
                return;
            }
        }
    }
}
