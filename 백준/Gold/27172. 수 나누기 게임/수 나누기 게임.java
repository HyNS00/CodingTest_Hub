
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int[] point = new int[max+1];
        boolean[] multiply = new boolean[max + 1];
        for(int tmp : arr) {
            multiply[tmp] = true;
        }
        for(int number : arr) {
            for(int y = number * 2; y <= max; y += number){
                if(multiply[y]) {
                    point[number]++;
                    point[y]--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(point[arr[i]]).append(' ');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
