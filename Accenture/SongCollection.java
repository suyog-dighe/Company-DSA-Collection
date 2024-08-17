package Accenture;

/*
→Alice has collection of songs represented as a string S where each character
 represents a song. A playlist is the substring of the given string with exactly
 k number of songs. She wants to create a playlist that contains maximum number of
  her favourite song which is 'a'. Your task is to find and return an integer value
    representing the maximum number of favourite songs that she can get in a single playlist.
 */
public class SongCollection {
    public static int findsubstring(String s,int k){
        int n=s.length();
        int i=0,j=-1,count=0,max=0;
        while (j<k-1){
            if (s.charAt(j++)=='a'){
                count++;
            }
        }
        max=count;
        while (j<n-1){
            if (s.charAt(i++)=='a'){
                count--;
            }
            if (s.charAt(j++)=='a'){
                count++;
            }
            max=Math.max(max,count);
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
