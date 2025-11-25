

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] air;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }
        int cnt = 0;

        while(true) {
            ArrayDeque<int[]> queue= new ArrayDeque<>();
            queue.add(new int[] {0,0});
            air = new boolean[n][m];
            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(map[nx][ny] == 0 && !air[nx][ny]) {
                        air[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }


            melt(air);

            cnt++;
            if(checker()) {
                break;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }
    private static boolean checker() {
        return Arrays.stream(map).flatMapToInt(x -> Arrays.stream(x))
                .allMatch(v -> v == 0);
    }
    private static void melt(boolean[][] air) {
        List<int[]> melting = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    find(i, j, melting);
                }
            }
        }
        for(int[] target : melting) {
            map[target[0]][target[1]] = 0;
        }
    }
    private static void find(int x, int y, List<int[]> melting) {
        int release = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || ny >= m || nx >= n) continue;
            if(map[nx][ny] == 0 && air[nx][ny]) {
                release++;
            }
        }
        if(release >= 2) {
            melting.add(new int[]{x, y});
        }
    }
}
