
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


        int n = Integer.parseInt(br.readLine());
        int v = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][n+1];
        List<List<int[]>> map = new ArrayList<>();
        for(int i =  0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.get(from).add(new int[]{to, value});
        }

        int INF = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }


        // 초기 가중치 반영

        for(int i = 1; i <= n; i++) {
            List<int[]> nodes = map.get(i);
            for(int j = 0; j < nodes.size(); j++) {
                int value = nodes.get(j)[1];
                int to = nodes.get(j)[0];

                if(dp[i][to] > value) {
                    dp[i][to] = value;
                }
            }
        }


        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                if(dp[i][k] == INF) continue;
                for(int j = 1; j <= n; j++) {
                    if(dp[k][j] == INF) continue;
                    dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sb.append(dp[i][j] == INF ? 0 : dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
