import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int curX;
    static int curY;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Comparator<int[]> comparator = Comparator
                .comparingInt((int[] coordinate) -> coordinate[2])
                .thenComparingInt((int[] coordinate) -> coordinate[0])
                .thenComparingInt((int[] coordinate) -> coordinate[1]);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    curX = i;
                    curY = j;
                    map[i][j] = 0;
                }

            }
        }
        // 왜 못 풀었는가??
        // 무엇인가 여러 조건이 있다 -> pq를 사용해서 진행해보자.
        // 최소 이동이라는게 크게 와닿지 않았다. -> 최소 이동거리니까 bfs를 생각하자
        // 그런 다음에 bfs
        int shark = 2;
        int remain = 2;
        int totalDist = 0;
        while(true) {
            int first = bfs(map,shark);
            if(first == -1) break;
            // -1 이 아니다 -> 먹었다.
            totalDist += first;
            remain--;
            if(remain == 0) {
                shark++;
                remain = shark; // 상어 크기 키우기
            }
        }
        bw.write(String.valueOf(totalDist));
        bw.close();
        br.close();
    }
    private static int bfs(int[][] map, int shark) {
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);

        pq.add(new int[] {curX,curY, 0});
        visited[curX][curY] = true;
        while(!pq.isEmpty()) {
            int[] poll = pq.poll();

            int cx = poll[0];
            int cy = poll[1];
            int dist = poll[2];

            if(map[cx][cy] > 0 && shark > map[cx][cy]) {
                map[cx][cy] = 0;
                curX = cx;
                curY = cy;
                return dist;
            }
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && ny < n && nx < n &&
                    !visited[nx][ny] && map[nx][ny] <= shark) {
                    visited[nx][ny] = true;
                    pq.add(new int[] {nx,ny, dist+1});
                }
            }
        }
        return -1;
    }
}
