

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        int[][] rgb = new int[n][3];

        for(int i = 0; i < n; i++) {
            rgb[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] colors = new int[n][3];
        colors[0][0] = rgb[0][0];
        colors[0][1] = rgb[0][1];
        colors[0][2] = rgb[0][2];


        for(int i = 1; i < n; i++) {
            colors[i][0] = Math.min(colors[i-1][1], colors[i-1][2]) + rgb[i][0];
            colors[i][1] = Math.min(colors[i-1][0], colors[i-1][2]) + rgb[i][1];
            colors[i][2] = Math.min(colors[i - 1][1], colors[i - 1][0]) + rgb[i][2];
        }

        int result = Math.min(Math.min(colors[n - 1][0], colors[n - 1][1]), colors[n - 1][2]);
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }


}
