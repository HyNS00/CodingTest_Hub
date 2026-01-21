import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[i] = new int[]{a, b};
        }

        Comparator<int[]> comp = Comparator.comparingInt((int[] arr) -> arr[1])
                .thenComparingInt((int[] arr) -> arr[0]);
        Arrays.sort(map, comp);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int[] tmp = map[i];
            sb.append(tmp[0]).append(" ").append(tmp[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
