import java.util.*;
class Solution {
    private class Category implements Comparable<Category> {
        private String alpha;
        private int value;
        
        private Category(String alpha, int value){
            this.alpha = alpha;
            this.value = value;
        }
        public int getValue(){
            return value;
        }
        public String getAlpha(){
            return alpha;
        }
        @Override
        public int compareTo(Category other){
            int num = Integer.compare(other.getValue(), this.getValue());
            if(num != 0){
                return num;
            }else{
                return this.getAlpha().compareTo(other.getAlpha());
            }
        }
            
        
    }
    private Category[][] categories ={
        new Category[]{new Category("R",0), new Category("T",0)},
        new Category[]{new Category("C",0), new Category("F",0)},
        new Category[]{new Category("J",0), new Category("M",0)},
        new Category[]{new Category("A",0), new Category("N",0)}
    };
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        for(int i  = 0; i < survey.length; i++){
            int choice = choices[i];
            String tmp = survey[i];
            if(choice > 4){
                addScore(tmp.charAt(1),choice);
            }else{
                addScore(tmp.charAt(0), choice);
            }
        }
        for(Category[] cat : categories){
            sb.append(choseOne(cat));
        }
        return sb.toString();
    }
    private void addScore(char c, int choice){
        int score = Math.abs(choice - 4);
        for(Category[] cat : categories){
            for(Category ca : cat){
                if(ca.getAlpha().equals(String.valueOf(c))){
                    ca.value += score;
                }
            }
        }
    }
    private String choseOne(Category[] cat){
        Arrays.sort(cat);
        return cat[0].getAlpha();
    }
}