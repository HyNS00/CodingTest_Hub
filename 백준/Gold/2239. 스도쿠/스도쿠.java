

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[][] map;
    static StringBuilder sb;
    static  BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[9][9];

        for(int i = 0; i < 9; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }
        dfs(0, 0);

    }
    public static void dfs(int row, int col) throws IOException {
        if(col == 9) {
            dfs(row+1,0);
            return;
        }

        if(row == 9) {
            sb = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.close();
            br.close();
            System.exit(0);
        }
        if(map[row][col] == 0) {
            for(int value = 1; value <= 9; value++) {
                if (checker(row, col, value)) {
                    map[row][col] = value;
                    dfs(row,col+1);
                    
                }
            }
            map[row][col] = 0;
        }else {
            dfs(row, col + 1);
        }

    }
    public static boolean checker(int row, int col, int value) {
        for(int i = 0; i < 9; i++) {
            if(map[row][i] == value) {
                return false;
            }
        }
        for(int i = 0; i < 9; i++) {
            if(map[i][col] == value) {
                return false;
            }
        }
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;

        for(int r = startRow; r < startRow+3; r++) {
            for(int c = startCol; c < startCol+3; c++) {
                if(map[r][c] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
