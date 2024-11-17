package Accenture_Coding;

public class SubStringSearch {
    public static int searchstringIndex(String s, String d){
        int index=s.indexOf(d);
        return (index != -1)? index : -1;
//        if (index !=-1){
//            return index;
//        }
//        return -1;

    }
    public static void main(String[] args) {
        String s="Aniket digh dighe";
        String d= "dighe";
        System.out.println(searchstringIndex(s,d));

    }
}
