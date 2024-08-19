package Accenture;
import java.util.*;

public class AllBasicCode {
    //1. Perfect Number Code
    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    // 2. Armstrong Number Code
    public static boolean isArmstrongNumber(int n) {
        int original = n, sum = 0, d = String.valueOf(n).length();
        while (n > 0) {
            int base = n % 10;
            sum += Math.pow(base, d);
            n /= 10;
        }
        return sum == original;
    }

    //3. Prime Number Code
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //4. Factorial Code
    public static int factorial(int n) {
        if (n == 0) return 1;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    //5. Fibonacci Number Code
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    //6. Palindrome Code
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    //7. GCD (Greatest Common Divisor) Code
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

        /*
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
         */
    }

    //8. LCM (Least Common Multiple) Code
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    //9. Sum of Digits Code
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    //10. Reverse String Code
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    //11. Bubble Sort Code
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //12. Merge Sort Code
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    //13. Binary Search Code
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Target not found
    }

    //14. Linear Search Code
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1; // Target not found
    }

    //15. Count Vowels Code
    public static int countVowels(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') count++;
        }
        return count;
    }

    //16. Find Maximum Element Code
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    //17. Find Minimum Element Code
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    //18 check Even or Odd Code
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    //19. Sum of Array Elements Code
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    //20. Reverse Array Code
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    //21. Sum of Primes Up to n
    public static int sumOfPrimesUpTo(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    //22. Suffix Sum
    public static int[] calculateSuffixSums(int[] arr) {
        int n = arr.length;
        int[] suffixSums = new int[n];
        suffixSums[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSums[i] = suffixSums[i + 1] + arr[i];
        }
        return suffixSums;
    }

    //23. Prefix Sum
    public static int[] calculatePrefixSums(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n];
        prefixSums[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + arr[i];
        }
        return prefixSums;
    }

    //24. Find Duplicate Elements
    public static Set<Integer> findDuplicates(int[] arr) {
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }
        return duplicates;
    }

    //25.  Find First Repeated Number
    public static int findFirstRepeated(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }

    //26. Find first Non-Repeated Number
    public static int findFirstNonRepeated(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // Find the first number with a count of 1
        for (int num : arr) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    //27. Find first Repeated Character
    public static char findFirstRepeatedCharacter(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }
        return '\0';
    }

    //28. Find first Non-Repeated Character
    public static char findFirstNonRepeatedCharacter(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (countMap.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    //29. Calculate Length of String Without .length()
    public static int calculateLength(String s) {
        int length = 0;
        for (int i = 0; ; i++) {
            if (s.charAt(i) == 0) { // When reaching the end, charAt() will throw IndexOutOfBoundsException
                break;
            }
            length++;
        }
        return length;
    }

    //30. Character Frequency Count in Alphabetical Order
    public static String frequencyCount(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (mp.containsKey(c)) {
                result.append(c).append(mp.get(c));
            }
        }
        return result.toString();
    }

    //31. Even Odd Segregation
    public static void segregation(int[] num) {
        int n = num.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (num[left] % 2 == 0) {
                left++;
            } else if (num[right] % 2 != 0) {
                right--;
            } else {
                // Swap even on the right with odd on the left
                int temp = num[left];
                num[left] = num[right];
                num[right] = temp;
                left++;
                right--;
            }
        }
    }




}
