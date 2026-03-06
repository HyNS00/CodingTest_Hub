
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        // 유니온 파인드 + 추가적으로 선택지가 넓은 쪽이 해야 최적이다.
        // 최대한 많은 걸 넣어야하기 때문
        int cnt = 0;
        int[] parent = new int[G+1];
        for(int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < P; i++) {
            int plane = Integer.parseInt(br.readLine());
            int root = find(plane,parent);
            if(root == 0) {
                break;
            }
            cnt++;

            union(root, root - 1, parent);

        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }
    static int find(int num, int[] parent){
        if(parent[num] == num) {
            return num;
        }
        int another = parent[num];
        int anotherRoot = find(another, parent);
        parent[num] = anotherRoot;
        return anotherRoot;
    }
    static void union(int a, int b, int[] parent) {
       parent[a] = b;
    }
}
