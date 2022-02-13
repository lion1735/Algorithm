import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {
    public static char[] s;
    public static String res;
    public static Stack<Character> stack;
    public static Stack<Integer> resStack;
    public static HashMap<Character, Integer> opMap;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        setOperation();
        int T = 10;
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(bf.readLine());
            s = bf.readLine().toCharArray();
            res = "";

            change(s);
            sb.append('#').append(test_case+1).append(' ').append(calc()).append('\n');
        }
        System.out.println(sb);
    }

    public static void setOperation() {
        opMap = new HashMap<>();
        opMap.put('(', 3);
        opMap.put(')', 3);
        opMap.put('*', 2);
        opMap.put('/', 2);
        opMap.put('+', 1);
        opMap.put('-', 1);
    }

    public static boolean isProceed(char op1, char op2) {
        if (opMap.get(op1) >= opMap.get(op2)) {
            return true;
        } else {
            return false;
        }
    }

    public static void change(char[] temp) {
        stack = new Stack<>();
        for (char c : temp) {
            if (c >= '1' && c <= '9') {
                res += c;
            } else if (stack.isEmpty()) {
                stack.add(c);
            } else {
                while (!stack.isEmpty() && isProceed(stack.peek(), c))
                    res += stack.pop();
                stack.add(c);
            }
        }
        while (!stack.isEmpty())
            res += stack.pop();
    }

    public static int calc() {
        char[] s = res.toCharArray();
        resStack = new Stack<>();
        for (char c : s) {
            if (c >= '*' && c <= '/') {
                switch (c) {
                    case '*':
                        int sol1 = resStack.pop() * resStack.pop();
                        resStack.add(sol1);
                        break;
                    case '/':
                        int A2 = resStack.pop();
                        int B2 = resStack.pop();
                        int sol2 = B2 / A2;
                        resStack.add(sol2);
                        break;
                    case '+':
                        int sol3 = resStack.pop() + resStack.pop();
                        resStack.add(sol3);
                        break;
                    case '-':
                        int A1 = resStack.pop();
                        int B1 = resStack.pop();
                        int sol4 = B1 - A1;
                        resStack.add(sol4);
                        break;
                }
            } else {
                resStack.add(c - '0');

            }
        }
        return resStack.pop();
    }
}
