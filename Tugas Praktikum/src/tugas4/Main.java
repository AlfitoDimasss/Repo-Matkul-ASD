package tugas4;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static long evaluatePostfix(String exp) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ',') {
                continue;
            } else if (Character.isDigit(c)) {
                String s = "";
                while (Character.isDigit(c)) {
                    s += c;
                    i++;
                    c = exp.charAt(i);
                }
                i--;
                double n = Double.parseDouble(s);
                stack.push(n);
            } else if (isOperator(c)) {
                double val1 = stack.pop();
                double val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '%':
                        stack.push(val2 % val1);
                        break;
                    case '^':
                        stack.push(Math.pow(val2, val1));
                        break;
                }
            }
        }
        return Math.round(stack.pop());
    }

    static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        String ex = io.next();
        io.close();
        System.out.println(evaluatePostfix(ex));
    }
}
