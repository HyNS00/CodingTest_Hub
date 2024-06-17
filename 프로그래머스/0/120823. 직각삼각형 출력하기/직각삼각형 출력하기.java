import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        // 받은 숫자만큼 반복, *을 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}