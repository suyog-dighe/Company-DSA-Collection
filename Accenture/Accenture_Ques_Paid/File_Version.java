package Accenture_Ques_Paid;
import java.util.*;

public class File_Version {
    public static int solve(int n, String[] arr) {
        int maxVer = -1;
        for (String s : arr) {
            if (s.length() >= 6 && s.startsWith("file_")) {
                int idx = 5;
                int ver = 0;
                boolean valid = true;

                while (idx < s.length()) {
                    char ch = s.charAt(idx);
                    if (Character.isDigit(ch)) {
                        ver = ver * 10 + (ch - '0');
                    } else {
                        valid = false; // invalid
                        break;
                    }
                    idx++;
                }

                if (valid) {
                    maxVer = Math.max(maxVer, ver);
                }
            }
        }
        return maxVer;
    }
    public static void main(String[] args) {
        String[] arr={"file_1","file_4","file_20m","fil_5","file 7","file_9"};
        System.out.println(solve(arr.length,arr));

    }
}
