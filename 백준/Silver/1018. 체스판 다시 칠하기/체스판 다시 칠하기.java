
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 짝수냐 홀수냐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 잘못 생각한 것 -> 최적의 값을 구해야한다 -> 시작포인트가 다른 것도 생각해야한다.

        char[][] map = new char[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        int maxValue = Integer.MAX_VALUE;
        for(int r = 0; r <= N-8; r++) {
            for (int c = 0; c <= M - 8; c++) {
                int repaints = Math.min(checkBoard(map,r,c,'B'), checkBoard(map,r,c,'W'));
                 maxValue = Math.min(maxValue,repaints);
            }
        }
        bw.write(String.valueOf(maxValue));
        bw.close();
        br.close();
    }
    static int checkBoard(char[][] map, int startR, int startCol , char standard) {
        int repairs = 0;
        char first;
        char second;

        if(standard == 'B') {
            first = 'B';
            second = 'W';
        }else {
            first = 'W';
            second = 'B';
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                char expectedColor = ((i+j) % 2 == 0) ? first : second;
                if(map[startR + i][startCol + j] != expectedColor){
                    repairs++;
                }
            }
        }
        return repairs;
    }
}

