import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < note.length; i++) {
            String s = note[i];
            
            if (map.containsKey(s)) {
                int value = map.get(s);
                map.put(s, ++value);
            }
            else {
                map.put(s, 1);
            }
        }
        
        for (int i = 0; i < magazine.length; i++) {
            String s = magazine[i];
            
            if (map.containsKey(s)) {
                int value = map.get(s);
                
                if (value == 1) {
                    map.remove(s);
                }
                else {
                    map.put(s, --value);
                }
            }
        }
        
        if (map.isEmpty()) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
