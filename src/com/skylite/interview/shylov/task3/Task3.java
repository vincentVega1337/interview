package com.skylite.interview.shylov.task3;

import java.math.BigInteger;

/**
 * Task: Find the sum of the digits in the number 100! (i.e. 100 factorial)
 * {Correct answer: 648}
 *
 * @author Artem Shylov
 * @author artem.shylov.1993@gmail.com
 */
public class Task3 {

    private static String VALUE = "100";

    public static void main(String[] args) {
        System.out.println("***PART 3***");
        String s = bigFactorial(new BigInteger(VALUE)).toString();
        System.out.println("!100: " + s);
        System.out.println("sum of digits: " + numberCounter(s));
        System.out.println("************");
    }

    /**
     * Standard factorial method with use BinInteger class
     *
     * @param value value needs get factorial
     * @return recursion call while value dong equals 1
     */
    public static BigInteger bigFactorial(BigInteger value) {
        if (value.equals(new BigInteger("1"))) {
            return value;
        }
        return value.multiply(bigFactorial(value.subtract(new BigInteger("1"))));
    }

    /**
     * Method get string value of number and return sum of digits
     *
     * @param number necessary number in string value
     * @return sum of the digits in the number
     */
    public static int numberCounter(String number) {
        int result = 0;

        for (int i = 0; i < number.length(); i++) {
            result += Character.getNumericValue(number.charAt(i));
        }
        return result;
    }
}
