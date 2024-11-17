package Accenture_Coding;

public class FindRhymingWord {
    public static int longestsuffix(String s, String w){
        int i=s.length()-1;
        int j=w.length()-1;
        int len=0;
        while (i>=0 && j>=0 && s.charAt(i)==w.charAt(j)){
            len++;
            i--;
            j--;
        }
        return len;
    }
    public static String  findmostRhymeWord(String s[],String word){
        String ans="";
        int maxlen=0;
        for (String  sc:s){
            int curr=longestsuffix(sc,word);
            if (curr>maxlen || curr==maxlen && word.length() <= ans.length()){
                ans=sc;
                maxlen=curr;
            }
        }
    return ans;
    }
    public static void main(String[] args) {
        String s[]={"gettlr","shutter","matter","patter"};
        String  w="wotter";
        System.out.println(findmostRhymeWord(s,w));
    }
}
