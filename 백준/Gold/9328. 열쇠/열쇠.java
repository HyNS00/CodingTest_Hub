
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static StringTokenizer st;
    static Set<Character> keys;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N + 2][M + 2];
            // +2를 해야 감쌀 수 있다.

            for(char[] row : map) {
                Arrays.fill(row, '.');
            }
            for(int i = 0; i < N; i++) {
                char[] tmp = br.readLine().toCharArray();

                for(int j = 0; j < M; j++) {
                    map[i+1][j+1] = tmp[j];
                }
            }

            String have = br.readLine();
            keys = new HashSet<>();

            if (!have.equals("0")) {
                for(char c : have.toCharArray()) {
                    keys.add(c);
                }
            }

            // 알파벳별 저장소 (26개) 만들기
            List<List<int[]>> store = new ArrayList<>();
            for(int i = 0; i < 26; i++) {
                store.add(new ArrayList<>());
            }
            int result = bfs(store);

            sb.append(result).append("\n");


        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static int bfs(List<List<int[]>> store) {
        int cnt = 0;
        boolean[][] visited = new boolean[N + 2][M + 2];
        visited[0][0] = true;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= N+2 || ny < 0 || ny >= M+2) continue;
                if(map[nx][ny] == '*') continue;

                if(map[nx][ny] == '$' && !visited[nx][ny]) {
                    cnt++;
                    map[nx][ny] = '.';
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }

                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                    if (!keys.contains(map[nx][ny])) {
                        keys.add(map[nx][ny]);
                        int size = map[nx][ny] - 'a';
                        List<int[]> doors = store.get(size);
                        queue.add(new int[] {nx,ny});
                        for(int[] tmp : doors) {
                            visited[tmp[0]][tmp[1]] = true;
                            map[tmp[0]][tmp[1]] = '.';
                            queue.add(tmp);
                        }
                        visited[nx][ny] = true;
                        map[nx][ny] = '.';
                    }else {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        map[nx][ny] = '.';
                    }
                }

                if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                    if (!keys.contains(Character.toLowerCase(map[nx][ny]))) {
                        int size = map[nx][ny] - 'A';
                        store.get(size).add(new int[]{nx, ny});

                    }else  {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        map[nx][ny] = '.';
                    }
                }
                if (map[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }

        }
        return cnt;
    }
}
