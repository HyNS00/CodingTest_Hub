

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // union find
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int parentA = findParent(a, parent);
            int parentB = findParent(b, parent);

            if(parentA != parentB) {
                union(parentA, parentB, parent);
            }else {
                result = i+1;
                break;
            }

        }
        result = result >= 0 ? result : 0;
        bw.write(String.valueOf(result));

        bw.close();
        br.close();
    }
    private static int findParent(int a,int[] parent) {
        if(parent[a] == a) {
            return a;
        }

        int root = parent[a];
        parent[a] = findParent(root, parent);
        return parent[a];
    }
    private static void union(int a, int b, int[] parent) {
        if(a > b) {
            parent[a] = b;
        }else {
            parent[b] = a;
        }
    }
}
