import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakeAnagrams {

    static int makeAnagrams(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();

        int count = 0;
        
        for (int i = 0; i < len1; i++) {
            arr1[str1[i] - 'a']++;
        }
        for (int i = 0; i < len2; i++) {
            arr2[str2[i] - 'a']++;
        }

        for (int i = 0; i < arr1.length; i++) {
            count += (int) Math.abs(arr1[i] - arr2[i]);
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();

        String b = scanner.nextLine();
        
        int result = makeAnagrams(a, b);
        System.out.println(result);

        scanner.close();
    }
}
