import java.util.Scanner;

/**
 * Java Advanced Example #2
 *
 * @author Булгаков В.В. 04.02.2025
 * 1. Реализовать операции сложения, вычитания, умножения и деления для калькулятора из предыдущего задания
 * 2. Поиск максимального элемента в массиве:
 * - задаем массив слов
 * - размерность массива произвольна, задается в консоли
 * - после чего в консоли вводятся слова в количестве равном заданной длине массива
 * - в полученном массиве необходимо найти самое длинное слово
 * - результат вывести на консоль
 * 3. Программа должна выполнять одно из заданий на выбор.
 * - Если в консоли ввести 1 - запуститься выполнение калькулятора
 * - Если в консоли ввести 2 - поиск максимального слова в массиве
 * Пример как это может выглядеть в консоли:
 * Enter number of task: (1 - calculator, 2 - string array)
 * 1
 * Enter the first number
 * 3
 */
public class CalcAndFindArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Выберем требуемый функционал
        System.out.println("Выберите тип задачи: (1 - калькулятор, 2 - поиск в строковом массиве): ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    //Калькулятор
                    int liResCalc = doCalc(sc);
                    break;
                case 2:
                    //Поиск в массиве
                    int liResArrayFind = DoArrayFind(sc);
                    break;
                default:
                    System.out.println("Некорректная операция");
            }
        } else {
            System.out.println("Некорректная операция");
        }
    }

    /**
     * Функция реализует простейший функционал калькулятора
     *
     * @param sc объект ввода
     * @return 0- успешное выполнение, -1 - в процессе работы произошла ошибка
     */
    public static int doCalc(Scanner sc) {
        double ldRes = 0;
        double ldVar1 = GetInputValue("Введите значение первой переменной: ", sc);
        if (Double.isNaN(ldVar1)) {
            System.out.println("Некорректное значение");
            return -1;
        }
        double ldVar2 = GetInputValue("Введите значение второй переменной: ", sc);
        if (Double.isNaN(ldVar2)) {
            System.out.println("Некорректное значение");
            return -1;
        }
        String lsOper = GetInputOperator("Введите арифметическую операцию (+,-,/,*): ", sc);
        if (lsOper.isEmpty()) {
            System.out.println("Некорректное значение");
            return -1;
        }
        switch (lsOper) {
            case "+":
                ldRes = ldVar1 + ldVar2;
                break;
            case "-":
                ldRes = ldVar1 - ldVar2;
                break;
            case "*":
                ldRes = ldVar1 * ldVar2;
                break;
            case "/":
                if (ldVar2 == 0) {
                    System.out.println("Деление на 0 недопустимо");
                    return -1;
                }
                ldRes = ldVar1 / ldVar2;

                break;
        }
        System.out.printf("\nРезультат: %.4f", ldRes);
        return 0;
    }

    /**
     * Функция реализует ввод массива слов и поиск длиннейшего в нем
     * Можно предварительно заполнить массив, потом так же в цикле его перебрать, но мы с целью экономии будем определять максимальную длину при вводе
     * Данный подход позволяет сократить код на один цикл
     *
     * @param sc объект ввода
     * @return 0- успешное выполнение, -1 - в процессе работы произошла ошибка
     */
    public static int DoArrayFind(Scanner sc) {
        String[] ArrayFind = new String[100];
        int i = 0;
        long llMax = Long.MIN_VALUE;
        String lsMaxWorld = "";
        String lsInput;
        do {
            lsInput = GetInputWord("Введите " + i + "-й элемент массива или \"-\" для завершения ввода, максимальное количество слов 100: ", sc);
            ArrayFind[i] = lsInput;
            if (llMax < lsInput.length()) {
                llMax = lsInput.length();
                lsMaxWorld = lsInput;
            }
            i++;
        } while (!(lsInput.isEmpty()) || i == 100);
        System.out.println("Массив");
        for (i = 0; i < ArrayFind.length; i++) {
            if (i == 0) System.out.print("[ ");
            if (ArrayFind[i] == null) {
                System.out.print(" ]");
                break;
            }
            System.out.print(ArrayFind[i] + " ");
        }
        System.out.println("\nСамое длинное слово: " + lsMaxWorld + ", его длина равна " + llMax + " симв.");
        return 0;
    }


    /**
     * Функция читает данные типа double
     *
     * @param prompt  Сообщение
     * @param scanner поток ввода
     * @return значение переменной либо неопределенное значение при некорректном вводе
     */
    public static double GetInputValue(String prompt, Scanner scanner) {
        //Сделаем отдельную функцию считывания с клавиатуры
        double ldRes;
        System.out.print(prompt);
        if (scanner.hasNextDouble()) {
            ldRes = scanner.nextDouble();
        } else {
            ldRes = Double.NaN;
        }
        return ldRes;
    }

    /**
     * Функция считывает арифметическую операцию
     *
     * @param prompt  Сообщение
     * @param scanner поток ввода
     * @return значение арифметической операции
     */
    public static String GetInputOperator(String prompt, Scanner scanner) {
        System.out.print(prompt);
        String lsOperator = scanner.next();
        if ((lsOperator.length() != 1) || !(lsOperator.matches("[+-/*]+"))) {
            lsOperator = "";
        }
        return lsOperator;
    }

    /**
     * Функция считывает слово для массива
     *
     * @param prompt  Сообщение
     * @param scanner поток ввода
     * @return значение слова или пустую строку как признак окончания ввода
     */
    public static String GetInputWord(String prompt, Scanner scanner) {
        System.out.print(prompt);
        String lsOperator = scanner.next();
        if (lsOperator.equals("-")) {
            lsOperator = "";
        }
        return lsOperator;
    }
}
