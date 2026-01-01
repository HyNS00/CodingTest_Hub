

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int an = Integer.parseInt(br.readLine());
        int[] arrayA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bn = Integer.parseInt(br.readLine());

        int[] arrayB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long cnt = 0;
        // 어떻게 해야할까.. 투포인터 같은데 아닌가?

        // 모든 경우의 값을 다 넣는다.
        List<Long> listA = new ArrayList<>();
        List<Long> listB = new ArrayList<>();

        for(int i = 0; i < an; i++) {
            long tmp = 0;
            for(int j = i; j < an; j++) {
               tmp += arrayA[j];
               listA.add(tmp);
           }
        }
        for(int i = 0; i < bn; i++) {
            long tmp = 0;
            for(int j = i; j < bn; j++) {
                tmp += arrayB[j];
                listB.add(tmp);
            }
        }

        listA.sort(Comparator.naturalOrder());
        listB.sort(Comparator.naturalOrder());

        int left = 0;
        int right = listB.size()-1;

        while(true) {
            if(left >= listA.size() || right < 0) break;
            long sum = listA.get(left) + listB.get(right);
            if(sum == T) {
                long curA = listA.get(left);
                int leftCount = 0;
                while(left < listA.size() && curA == listA.get(left)) {
                    left++;
                    leftCount++;
                }

                long curB = listB.get(right);
                int rightCount = 0;
                while(right > -1 && curB == listB.get(right)) {
                    right--;
                    rightCount++;
                }
                cnt +=(long) leftCount * rightCount;
            }
            else if(sum > T) {
                right--;
            }else {
                left++;
            }

        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();


    }
}
