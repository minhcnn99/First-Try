package changbase;

import java.util.Scanner;

public class ChangBase {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ChangBase cb = new ChangBase();
        System.out.println("2- Binary");
        System.out.println("10- Decimal");
        System.out.println("16- Hexacimal");
        int baseIn = cb.checkBase("Choose your input base: ");
        int baseOut = cb.checkBase("Choose your output base: ");
        String in = null;
        String test = "0123456789ABCDEF";
        boolean check = false, temp;
        System.out.print("Input the number you want to change base: ");
        while (check == false) {
            in = sc.nextLine();
            temp = true;
            for (int i = 0; i < in.length(); i++) {
                //122010101
                for (int j = 0; j < baseIn; j++) {
                    if (in.charAt(i) == test.charAt(j)) {
                        break;
                    } else if (j == baseIn - 1) {
                        System.out.println("Wrong input!\nPlease re-input: ");
                        temp = false;
                        break;
                    }
                }
                if (!temp) {
                    break;
                }
            }
            if (temp == true) {
                check = true;
            } else {
                continue;
            }
        }
        int s = 0;
        for (int i = in.length() - 1; i >= 0; i--) {
//            for (int j = 0; j < baseIn; j++) {
//                if (in.charAt(i) == test.charAt(j)) {
//                    s += j * Math.pow(baseIn, in.length() - i - 1);
//                }
//            }
            s += test.indexOf(in.charAt(i)) * Math.pow(baseIn, in.length() - i - 1);
        }
        String out = "";
        while (s != 0) {
            out += test.charAt(s % baseOut);
            s /= baseOut;
        }
        StringBuilder o = new StringBuilder();
        o.append(out);
        System.out.println("Result: " + o.reverse());
    }

    public int checkBase(String Mess) {
        int base = 0;
        do {
            System.out.print(Mess);
            try {
                base = Integer.parseInt(sc.nextLine());
                if (base != 2 && base != 10 && base != 16) {
                    System.out.println("Must be 2/10/16!");
                } else {
                    return base;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Must be a number!");
            }
        } while (true);
    }

}
