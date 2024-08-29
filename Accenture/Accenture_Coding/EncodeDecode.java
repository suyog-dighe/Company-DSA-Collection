package Accenture_Coding;

public class EncodeDecode {
    public static String encodeDecode(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '_') {
                sb.append(" ");
            } else if (ch == '#') {
                sb.append("1");
            } else if (Character.isDigit(ch)) {
                // Handle numbers with multiple digits
                StringBuilder num = new StringBuilder();
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i));
                    i++;
                }
                i--; // Adjust index after the inner loop

                int number = Integer.parseInt(num.toString());
                if (number >= 1 && number <= 26) {
                    sb.append((char) ('A' + number - 1));
                } else {
                    sb.append(num.toString()); // Append the number itself if out of range
                }
            } else {
                sb.append(ch); // Keep other characters as is
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "21 22 23 _#1234";
        System.out.println(encodeDecode(s));  // Expected output: "U V W 1ABCD"
    }
}
