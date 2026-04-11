
import java.io.*;
import java.util.Arrays;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] w = new int[N][N];
        for(int i = 0; i < N; i++) {
            w[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[1 << N][N];
        for(int[] row : dp) {
            Arrays.fill(row, INF);
        }
        int fullVisited = (1 << N) -1;
        dp[1][0] = 0;
        for(int v = 1; v <= fullVisited; v++) {
            for(int curr = 0; curr < N; curr++) {
                if(dp[v][curr] == INF) continue; // v curr이 INF면 도달할 수 없다는 의미

                for(int next = 0; next < N; next++) {
                    if((v & (1 << next)) != 0) continue;
                    if(w[curr][next] == 0) continue;

                    int nextValue = v | (1 << next);
                    dp[nextValue][next] = Math.min(dp[nextValue][next], dp[v][curr] + w[curr][next]);
                }
            }
        }

        int ans = INF;
        // List , Array에 담아두고 비교해도 되는데 그냥 전체적ㅇ로 비교해도 문제 x
        // 마지막 위치에서 모두 방문하고 0으로 돌아오는 값 계산
        for (int i = 1; i < N; i++) {
            if(w[i][0] == 0) continue;
            if(dp[fullVisited][i] == INF) continue;
            ans = Math.min(ans, dp[fullVisited][i] + w[i][0]);
        }
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();

    }
}
