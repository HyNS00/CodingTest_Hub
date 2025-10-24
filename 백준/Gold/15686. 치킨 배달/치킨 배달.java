
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        List<int[]> chickens = new ArrayList<>();
        List<int[]> homes = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int curr = Integer.parseInt(st.nextToken());
                map[i][j] = curr;
                if(curr == 1) {
                    homes.add(new int[] {i,j});
                }else  if(curr == 2) {
                    chickens.add(new int[] {i,j});
                }
            }
        }

        // 백트래킹 -> 조합
        // 조합을 쓸거면 startIdx, 순열 쓸거면 visited로 중복 체크
        maker(m, 0, 0, homes, chickens, new ArrayList<>());
        bw.write(String.valueOf(result));
        bw.close();
        br.close();


    }
    private static void maker(int m, int depth, int startIdx, List<int[]> home, List<int[]> chickens, List<int[]> current){
        if(m == depth) {
            int sum = checker(current, home);
            result = Math.min(sum, result);
            return;
        }
        for(int i = startIdx; i < chickens.size(); i++) {
            current.add(chickens.get(i));
            maker(m,depth+1,i+1,home,chickens,current); // startIdx 가 아니라 i+1
            current.remove(current.size() - 1);
        }
    }

    private static int checker(List<int[]> current, List<int[]> home) {
        int sum = 0;
        for(int[] tmp : home) {
            int minDist = Integer.MAX_VALUE;
            for(int[] curr : current) {
                int dist = Math.abs(tmp[0] - curr[0]) + Math.abs(tmp[1] - curr[1]);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }
        return sum;
    }
}
