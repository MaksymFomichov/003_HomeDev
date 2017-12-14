package com.fomichov.gmail.m.hibernate.work;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

class MyUtils {

    // проверяем на целое число и на совпадение с массивом разрешенных значений
    static int checkChoice(int[] listChoice) {
        int temp = checkInt();
        while (true){
            for (int aListChoice : listChoice) {
                if (aListChoice == temp) {
                    return temp;
                }
            }
            System.out.println("Такого пункта меню нет, попробуйте ещё раз!");
            temp = checkInt();
        }
    }

    // проверяем на BigDecimal
    static BigDecimal checkBigDecimal() {
        Scanner sc = new Scanner(System.in);
        BigDecimal value;
        while (true) {
            try {
                value = sc.nextBigDecimal();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Возможен ввод только чисел!");
                sc.nextLine();
            }
        }
        return value;
    }


    // проверяем на long и на совпадение с массивом разрешенных значений
    static Long checkId(List<Long> listId) {
        Long temp = checkLong();
        while (true){
            for (Long aListChoice : listId) {
                if (aListChoice.equals(temp)) {
                    return temp;
                }
            }
            System.out.println("Такого id нет, попробуйте ещё раз!");
            temp = checkLong();
        }
    }

    private static Long checkLong(){
        Scanner sc = new Scanner(System.in);
        Long value;
        while (true) {
            try {
                value = sc.nextLong();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Возможен ввод только целых чисел!");
                sc.nextLine();
            }
        }
        return value;
    }

    private static int checkInt(){
        Scanner sc = new Scanner(System.in);
        int value;
        while (true) {
            try {
                value = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Возможен ввод только целых чисел!");
                sc.nextLine();
            }
        }
        return value;
    }
}
