import java.util.Scanner;
public class Solution {
	static int answer;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for(int t = 0; t < 10; t++){
			int T = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			answer = 1;
			answer = recur(n,m);
			
			System.out.println("#" + T + " "+answer+"\n");
		}
	}
	public static int recur(int n, int m){
		if(m == 0){
			return answer;
		}
		
		answer *= n;
		
		return recur(n,m-1);
		
	}
}
