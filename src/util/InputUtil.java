package util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner sc = new Scanner(System.in);

    public static String str(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    public static int num(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine().trim());
    }

    public static double dbl(String msg) {
        System.out.print(msg);
        return Double.parseDouble(sc.nextLine().trim());
    }
}
