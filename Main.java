package ru.corruptzero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        String problem = "7 10 - 2 3 + *";    // (10-7) * (2+3) = 15
        ArrayList<String> elems = new ArrayList<>(Arrays.asList(problem.split(" ")));
        for (String elem : elems) {
            try {
                Integer.parseInt(elem);
                stringStack.push(elem);
            } catch (Exception ignored) {
                int x = Integer.parseInt(stringStack.pop());
                int y = Integer.parseInt(stringStack.pop());
                switch (elem) {
                    case "-" -> stringStack.push(String.valueOf(x - y));
                    case "+" -> stringStack.push(String.valueOf(x + y));
                    case "/" -> stringStack.push(String.valueOf(x / y));
                    case "*" -> stringStack.push(String.valueOf(x * y));
                    default -> System.out.println("Неизвестная операция");
                }

            }
        }
        System.out.println("Результат: " + stringStack.pop());

    }
}
