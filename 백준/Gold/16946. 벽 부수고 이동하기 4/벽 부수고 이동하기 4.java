
import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[][] map;
    static int[][] group;
    static int[][] result;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static boolean[][] visited;
    static Map<Integer,Integer> store;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        // 그룹으로 나눠준다.
        group = new int[n][m];
        store = new HashMap<>();
        visited = new boolean[n][m];
        result = new int[n][m];
        int idx = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    int size = dfs(i,j,n,m,idx);
                    store.put(idx, size);
                    idx++;
                }
            }
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Set<Integer> set = new HashSet<>();
                if(map[i][j] == 1) {
                    result[i][j] = 1;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx >= 0 && ny >= 0 && nx < n && ny < m && group[nx][ny] > 0) {
                            set.add(group[nx][ny]);
                        }
                    }
                }
                for(int num : set) {
                    result[i][j] += store.get(num);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(result[i][j] % 10);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static int dfs(int x,int y,int n ,int m,int idx) {
        int cnt = 1;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{x, y});
        group[x][y] = idx;
        visited[x][y] = true;
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int cx = curr[0];
            int cy = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    cnt++;
                    stack.push(new int[]{nx, ny});
                    group[nx][ny] = idx;
                }
            }
        }

        return cnt;
    }

}
