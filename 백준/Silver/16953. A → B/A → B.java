
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());

        // bfs 보다는 그리디 -> 거기서도 역 그리디로 풀어보자

        // 어차피 연산은 *2 또는 *10 +1 밖에 없다.
        // 그 두 가지로 안나눠진다면 -1 로 해도 상관없다.
        int step = 1;
        if(n == m) step = 0;
        while(n < m) {
            if(m % 10 == 1) {
                m = (m-1) /10;
                step++;
            }else if(m % 2 == 0){
                m /= 2;
                step++;
            }else {
                step = -1;
                break;
            }
        }
        if(n != m) step = -1;
        bw.write(String.valueOf(step));
        bw.close();
        br.close();
    }

}
