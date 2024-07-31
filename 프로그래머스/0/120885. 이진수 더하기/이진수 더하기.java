class Solution {
    public String solution(String bin1, String bin2) {
        // 먼저 바꿔주는 함수
        double bin1N = changeToNum(bin1);
        double bin2N = changeToNum(bin2);
        int sum = (int) (bin1N + bin2N);
        return changeToBin(sum);
    }
    public double changeToNum(String str){
        String[] tmp = str.split("");
        double num = 0;
        int power = 0;
        for(int i = tmp.length-1; i >= 0; i--){
            double tmpNum = Integer.parseInt(tmp[i]) * Math.pow(2,power);
            num += tmpNum;
            power++;
        }
        return num;
    }
    public String changeToBin(int num){
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int a = num % 2;
            num /= 2;
            sb.append(a);
        }
        return sb.reverse().toString();
    }
}