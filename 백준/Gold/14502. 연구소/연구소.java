
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int maxValue = Integer.MIN_VALUE;
    static int[][] map;
    static int n;
    static int m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        // 브루트 포스
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

        dfs(0);
        bw.write(String.valueOf(maxValue));

        bw.close();
        br.close();
    }
    static void dfs(int depth) {
        if(depth == 3) {
            maxValue = Math.max(maxValue, bfs());
            return;
        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }

    }
    static int bfs() {
        int[][] bfsMap = new int[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bfsMap[i][j] = map[i][j];
                if(map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currX = poll[0];
            int currY = poll[1];
            for(int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if(nx < n && ny < m && nx >= 0 && ny >= 0
                    && bfsMap[nx][ny] == 0) {
                    bfsMap[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return countVirus(bfsMap);
    }
    static int countVirus(int[][] bfsMap) {
        int size = 0;

        for(int i = 0; i < bfsMap.length; i++) {
            for(int j = 0; j < bfsMap[0].length; j++) {
                if(bfsMap[i][j] == 0) {
                    size++;
                }
            }
        }
        return size;
    }
}
