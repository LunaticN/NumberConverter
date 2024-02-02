import java.util.Scanner;
import java.util.Arrays;


class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10 or 16): \nOtherwise, enter a different base to convert from base 10 to: ");


        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);


        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int num = Integer.parseInt(number);


        s.close();


        NumberConverter nc = new NumberConverter(num, base);
        int[] digits = nc.getDigits();
        if (base == 2){
            System.out.println("--------------------------------");
            System.out.println("Original Number: " + nc.displayOriginalNumber());
            System.out.println("Decimal: " + nc.convertToDecimal(2));
            System.out.println("Octal: " + nc.convertToOctal());
            System.out.println("Hexadecimal: " + nc.convertToHexadecimal());
        }
        else if (base == 8){
            System.out.println("--------------------------------");
            System.out.println("Original Number: " + nc.displayOriginalNumber());
            System.out.println("Binary: " + nc.convertToBinary());
            System.out.println("Decimal: " + nc.convertToDecimal(8));
            System.out.println("Hexadecimal: " + nc.convertToHexadecimal());
        }
        else if (base == 10){
            System.out.println("--------------------------------");
            System.out.println("Original Number: " + nc.displayOriginalNumber());
            System.out.println("Binary: " + nc.convertToBinary());
            System.out.println("Octal: " + nc.convertToOctal());
            System.out.println("Hexadecimal: " + nc.convertToHexadecimal());
        }
        else if (base == 16){
            System.out.println("--------------------------------");
            System.out.println("Original Number: " + nc.displayOriginalNumber());
            System.out.println("Binary: " + nc.convertToBinary());
            System.out.println("Decimal: " + nc.convertToDecimal(16));
            System.out.println("Octal: " + nc.convertToOctal());
        }
        else{
            System.out.println("--------------------------------");
            System.out.println("Original Decimal (Base 10) Number: " + nc.displayOriginalNumber());
            System.out.println("Base " + base + ": " + nc.convert10ToAnyBase(base));
        }

//        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
//        System.out.println("Number: " + nc.displayOriginalNumber());
//        System.out.println("Binary: " + nc.convertToBinary());
//        System.out.println("Octal: " + nc.convertToOctal());
//        System.out.println("Hexa: " + nc.convertToHexadecimal());
//        System.out.println("Choice: " + nc.convert10ToAnyBase(60));
    }
}
