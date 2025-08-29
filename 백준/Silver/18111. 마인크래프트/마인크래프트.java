

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                min = Math.min(tmp,min);
                max = Math.max(tmp,max);
            }
        }
        int time = Integer.MAX_VALUE;
        int height = -1;
//        System.out.println("min = " + min);
//        System.out.println("max = " + max);
        for(int i = min; i <= max; i++){
            int remove = 0;
            int add = 0;
            for(int r = 0; r < N; r++){
                for(int c = 0; c < M; c++){
                    int curr = map[r][c];
                    if(curr >= i) {
                        remove += (curr - i);
                    }else {
                        add += (i - curr);
                    }
                }
            }
            int currTime = (remove * 2) + add;
            if(B + remove >= add && currTime <= time) {

                time = currTime;
                height = i;
            }
        }
        sb.append(time).append(" ").append(height);

        bw.write(sb.toString());
        bw.close();
        br.close();


    }
}
