
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int need = Integer.parseInt(st.nextToken());
        int village = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < village; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            list.add(new int[]{price, person});
        }
        // 최소 비용
        int INF = 1_000_000_000;
        int[] dp = new int[need + 101];
        Arrays.fill(dp, INF);
        dp[0]= 0;
        for(int[] curr : list) {
            int price = curr[0];
            int person = curr[1];

            for(int i = person; i <= need+100; i++) {
                dp[i] = Math.min(dp[i], dp[i - person] + price);
            }
        }
        int answer = INF;
        for(int i = need; i <= need+100; i++) {
            answer = Math.min(dp[i], answer);
        }
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
