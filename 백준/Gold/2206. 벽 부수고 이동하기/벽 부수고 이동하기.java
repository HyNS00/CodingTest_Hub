
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;
        int dist;
        int bomb;

        public Node(int x, int y, int dist, int bomb) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.bomb = bomb;
        }
    }
    static int[][] map;
    static StringTokenizer st;
    static int n;
    static int m;
    static int value = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = tmp[j] - '0';
            }
        }
        bfs();
        bw.write(String.valueOf(value));
        bw.close();
        br.close();

    }
    private static void bfs() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean[][][] visited = new boolean[n][m][2];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            int bomb = poll.bomb;
            int dist = poll.dist;

            if(x == n-1 && y == m-1) {
                value = dist;
                return;
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == 0 && !visited[nx][ny][bomb]) {
                    visited[nx][ny][bomb] = true;
                    queue.add(new Node(nx, ny, dist + 1, bomb));
                } else if (map[nx][ny] == 1 && bomb == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.add(new Node(nx, ny, dist + 1, 1));
                }
            }
        }
    }
}
