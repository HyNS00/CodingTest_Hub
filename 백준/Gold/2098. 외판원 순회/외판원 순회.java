import java.io.*;
import java.util.Arrays;

public class Main {
    static int[][] w;
    static int INF = 987_654_321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        w = new int[n][n];


        for(int i = 0; i < n; i++) {
            w[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        // dp [방문한 곳][현재 위치]
        int[][] dp = new int[1 << n][n];
        for(int[] row : dp) {
            Arrays.fill(row,INF);
        }

        dp[1][0] = 0;
        int fullVisited = (1 << n) -1;
        for(int i = 1; i <= fullVisited; i++) {
            for(int j = 0; j < n; j++) {
                // 현재 어디까지 방문했고 어디에 있는지
                if(dp[i][j] == INF) continue;

                for(int next = 0; next < n; next++) {
                    // 다음은 어디로 갈지

                    if((i & (1 << next))!= 0) continue; // 이미 방문했을 경우
                    // 방문을 했다면 0이 아닌값이 나옴, 방문안했으면 0이 나옴
                    if(w[j][next] == 0) continue; // 가는 길이 없으면 넘긴다.

                    int nextValue = i | (1 << next);
                    dp[nextValue][next] = Math.min(dp[nextValue][next], dp[i][j] + w[j][next]);
                }
            }
        }
        int ans = INF;
        for(int i = 1; i < n; i++) {
            if(w[i][0] == 0)  continue;

            ans = Math.min(ans, dp[fullVisited][i] + w[i][0]);
        }
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }

}
