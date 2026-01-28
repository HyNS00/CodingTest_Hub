

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int[][] map = new int[a+1][b+1];
            for(int i = 0; i <= b; i++) {
                map[0][i] = i;
            }
            for(int i = 1; i <= a; i++) {
                for(int j = 1; j <= b; j++) {
                    for(int k = 1; k <= j; k++) {
                        map[i][j] += map[i-1][k];
                    }
                }
            }
            sb.append(map[a][b]).append("\n");

        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
