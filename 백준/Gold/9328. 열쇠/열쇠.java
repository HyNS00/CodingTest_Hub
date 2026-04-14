

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static int M;
    static char[][] map ;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N + 2][M + 2];
            for (char[] row : map) {
                Arrays.fill(row, '.');
            }
            for(int i = 0; i < N; i++) {
                String tmp = br.readLine();
                for(int j = 0; j < M; j++) {
                    map[i + 1][j + 1] = tmp.charAt(j);
                }
            }
            String k = br.readLine();
            Set<Character> keys = new HashSet<>();
            if (!k.equals("0")) {
                for (char c : k.toCharArray()) {
                    keys.add(c);
                }
            }
            // 26개의 알파벳 순서만큼 위치 추가
            List<List<int[]>> list = new ArrayList<>();
            for(int i = 0; i < 26; i++) {
                list.add(new ArrayList<>());
            }

            sb.append(bfs(keys, list)).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static int bfs(Set<Character> keys, List<List<int[]>> list) {
        int cnt = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N + 2][M + 2];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N + 2 || ny >= M + 2) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == '*') continue;

                char c = map[nx][ny];

                if ('A' <= c && c <= 'Z') {
                    char key = Character.toLowerCase(c);
                    if (!keys.contains(key)) {
                        list.get(c - 'A').add(new int[]{nx, ny});
                        continue;
                    }
                }

                visited[nx][ny] = true;

                if (c == '$') {
                    cnt++;
                    map[nx][ny] = '.';
                } else if ('a' <= c && c <= 'z') {
                    if (!keys.contains(c)) {
                        keys.add(c);

                        for (int[] pos : list.get(c - 'a')) {
                            if (!visited[pos[0]][pos[1]]) {
                                visited[pos[0]][pos[1]] = true;
                                queue.add(new int[]{pos[0], pos[1]});
                            }
                        }
                    }
                    map[nx][ny] = '.';
                }

                queue.add(new int[]{nx, ny});
            }
        }

        return cnt;
    }

}
