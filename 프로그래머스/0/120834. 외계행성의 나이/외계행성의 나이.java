class Solution {
    public String solution(int age) {
         StringBuilder sb = new StringBuilder();
         char[] ageArr = String.valueOf(age).toCharArray();
         char[] ageN = {'a','b','c','d','e','f','g','h','i','j'};
         for(char a : ageArr){
             sb.append(ageN[a -'0']);
         }
        return sb.toString();
    }
}