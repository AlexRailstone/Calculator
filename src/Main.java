import java.util.Scanner;

public class Main {
    static int num1,num2;
    static char operation;
    static int result;
    static String resRoman;
    static Roman roman2 = new Roman();
    static Op op = new Op();

    public static void main(String[] args) throws Exception {
        System.out.println("Input:");
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        calc(input1);
    }
    public static String calc(String input) throws Exception {
        String[] blocks = input.split(" ");
        // блок проверки строки
        if (blocks.length > 3) {
            throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (blocks.length <= 1) {
            throw new Exception("//т.к. строка не является математической операцией");
        }
        if (isA(blocks[0]) || isA(blocks[2])) {
            if (isR(blocks[0]) && isR(blocks[2])) {
                result = 0;
                num1 = Integer.parseInt(blocks[0]);
                for (int i = 1; i < blocks.length - 1; i += 2) {
                    operation = blocks[i].charAt(0);
                    num2 = Integer.parseInt(blocks[i + 1]);

                }
                // блок проверки переменных
                if (num1 > 10) {
                    throw new Exception("//т.к. не удовлетворяет заданию - не больше 10");
                } else if (num1 < 0) {
                    throw new Exception("//т.к. не удовлетворяет заданию - меньше 0");
                } else if (num2 > 10) {
                    throw new Exception("//т.к. не удовлетворяет заданию - не больше 10");
                } else if (num2 < 0) {
                    throw new Exception("//т.к. не удовлетворяет заданию - меньше 0");
                } else {
                    result = op.calc(num1, operation,num2 );
                    System.out.println("Output:");
                    System.out.println(result);
                }
            }
        } else {
            result = 0;
            num1 = roman2.romanToNumber(blocks[0]);
            for (int i = 1; i < blocks.length - 1; i += 2) {
                operation = blocks[i].charAt(0);
                num2 = roman2.romanToNumber(blocks[i + 1]);
            }
            // проверка отрицательных чисел
            if (operation == '-' && num2 > num1) {
                throw new Exception("//т.к. в римской системе нет отрицательных чисел");
            } else {
                System.out.println("Output:");
                result = op.calc(num1, operation, num2);
                resRoman = roman2.convertNumToRoman(result);
                System.out.println(resRoman);
            }
        }
        return input;
    }
        // проверка для if
    private static boolean isA(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // проверка для I + 1
    private static boolean isR(String s) throws Exception {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            throw new Exception("//т.к. используются одновременно разные системы счисления");
        }
    }

}
