package com.skylite.interview.shylov.task1;

import java.util.Scanner;

/**
 * Task:
 * Если мы из корректно записанного арифметического выражения, содержащего числа,
 * знаки операций и открывающие и закрывающие круглые скобки выбросим числа и знаки операций,
 * а затем запишем оставшиеся в выражении скобки без пробелов между ними,
 * то полученный результат назовем правильным скобочным выражением
 * [ * скобочное выражение "(()(()))" - правильное, а "()(" и "())(" - нет].
 * Найти число правильных скобочных выражений, содержащих N открывающихся и N закрывающихся скобок. N вводится с клавиатуры. N неотрицательное целое число.
 * <p>
 * Task reduces to finding Catalans number of initial value
 *
 *  * @author Artem Shylov
 *  * @author artem.shylov.1993@gmail.com
 */
public class Task1 {

    public static void main(String[] args) {
        System.out.println("***PART 1***");
        int n = readValueFromConsole();
        System.out.println("Catalans number = " + calculateCatalanNumber(n));
        System.out.println("************");
    }

    /**
     * Get initial value and calculate Catalan's number
     *
     * @param n value for calculate
     * @return Catalan's number of input value
     */
    public static long calculateCatalanNumber(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * 2 * (2 * i + 1) / (i + 2);
        }
        return result;
    }

    /**
     * Read integer value from console
     *
     * @return entered value
     */
    private static int readValueFromConsole() {
        int result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter value for task 1:");
        result = scanner.nextInt();
        return result;
    }
}

