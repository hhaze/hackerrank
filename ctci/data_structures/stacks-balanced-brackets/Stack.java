import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static boolean isBalancedBrackets(String s) {
        Stack<Character> st = new Stack<Character>();
        
        if (s.length() % 2 != 0) {
            return false;
        }
        else {
            char[] arr = s.toCharArray();
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
                    st.push(arr[i]);
                }
                else if (arr[i] == '}') {
                    if (st.empty()) {
                        return false;
                    }
                    else {
                        char c = st.peek();
                        if (c == '{') {
                            st.pop();
                        }
                    }
                }
                else if (arr[i] == ']') {
                    if (st.empty()) {
                        return false;
                    }
                    else {
                        char c = st.peek();
                        if (c == '[') {
                            st.pop();
                        }
                    }
                }
                else if (arr[i] == ')') {
                    if (st.empty()) {
                        return false;
                    }
                    else {
                        char c = st.peek();
                        if (c == '(') {
                            st.pop();
                        }
                    }
                }
            }
            
            if (st.empty()) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            boolean result = isBalancedBrackets(expression);
            
            if (result) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO"); 
            }
        }

        scanner.close();
    }
}

