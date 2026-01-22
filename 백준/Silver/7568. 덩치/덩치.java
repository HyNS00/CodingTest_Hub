

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] participants = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            participants[i] = new int[]{weight, height};

        }
        // 브루트 포스
        for(int i = 0; i < n; i++) {
            int rank = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                if(participants[j][0] > participants[i][0] && participants[j][1] > participants[i][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
