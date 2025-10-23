

import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][3];
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];

        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }
        StringBuilder sb = new StringBuilder();
        if(n == 1) {
            int min = Arrays.stream(map[0]).min().getAsInt();
            int max = Arrays.stream(map[0]).max().getAsInt();
            sb.append(max).append(" ").append(min);
        }else {
            for(int i= 0; i < 3; i++){
                    maxDp[0][i] = map[0][i];
                    minDp[0][i] = map[0][i];
            }

            for(int i = 1; i < n; i++){
                maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + map[i][0];
                maxDp[i][1] = Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2])) + map[i][1];
                maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + map[i][2];

                minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + map[i][0];
                minDp[i][1] = Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2])) + map[i][1];
                minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + map[i][2];
            }
            int min = Arrays.stream(minDp[n-1]).min().getAsInt();
            int max = Arrays.stream(maxDp[n-1]).max().getAsInt();
            sb.append(max).append(" ").append(min);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
