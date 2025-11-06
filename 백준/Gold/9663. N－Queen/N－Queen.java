import java.io.*;

public class Main {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n][n];

        dfs(map, 0, n);
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();

    }

    private static void dfs(boolean[][] map, int depth, int n) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isPossible(map, depth, i, n)) {
                map[depth][i] = true;
                dfs(map, depth + 1, n);
                map[depth][i] = false;
            }
        }

    }

    private static boolean isPossible(boolean[][] map, int depth, int col, int n) {
        // 아래 방향은 상관없다
        for (int i = 0; i < n; i++) {
            if (map[i][col]) return false;
        }

        for (int i = depth - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (map[i][j]) return false;
        }

        for (int i = depth - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (map[i][j]) return false;
        }
        return true;

    }
}
