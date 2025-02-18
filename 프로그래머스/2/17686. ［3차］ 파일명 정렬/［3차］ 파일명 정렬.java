import java.util.*;
import java.util.stream.*;
class Solution {
    private static class File{
        private String header;
        private int number;
        private int index;
        private String original;
        private File(String header, int number, int index, String original){
            this.header = header;
            this.number = number;
            this.index = index;
            this.original = original;
        }
        public String getHeader(){
            return header;
        }
        
        public int getNumber(){
            return number;
        }
        
        public int getIndex(){
            return index;
        }
        
        public String getOriginal(){
            return original;
        }
        public static File create(String str, int index){
            int i = 0; 
            String header = "";
            String num = "";
            while(i < str.length() && !Character.isDigit(str.charAt(i))){
                header+= str.charAt(i);
                i++;
            }
            
            while(i < str.length() && Character.isDigit(str.charAt(i))){
                num += str.charAt(i);
                i++;
            }
            return new File(header, Integer.parseInt(num), index, str);
        }
        
    }
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for(int i = 0; i < files.length; i++){
            list.add(File.create(files[i], i));
        }
        
        Comparator<File> comparator = Comparator.comparing((File f) -> f.getHeader().toLowerCase())
            .thenComparingInt(File::getNumber)
            .thenComparing(File::getIndex);
        
        list.sort(comparator);
        
        return list.stream().map(File::getOriginal).toArray(String[]::new);
        
    }
}