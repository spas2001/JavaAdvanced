import java.util.Scanner;

/**
 * Java Advanced Example #1
 *
 * @author Булгаков В.В. 03.02.2025
 * - Реализовать сложение дробных чисел, которые пользователь вводит в консоль.
 * - Использовать комментарии и JavaDoc при описании метода.
 * - Использовать форматирование при выводе результата в консоль.
 * Полученный результат округлять до 4-х знаков после запятой.
 * Запушить проект в свой репозиторий на GitHub и прикрепить ссылку на него в ответе на задание
 * Доп задание по желание: добавить возможность выбора другой операции (сложение, вычитание, деление, умножение)
 */


public class Base {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ldRes = 0;
        double ldVar1 = GetInputValue("Введите значение первой переменной: ", sc);
        if (Double.isNaN(ldVar1) ) {
            System.out.println("Некорректное значение");
            return;
        }
        double ldVar2 = GetInputValue("Введите значение второй переменной: ", sc);
        if (Double.isNaN(ldVar2) ) {
            System.out.println("Некорректное значение");
            return;
        }
        String lsOper = GetInputOperator("Введите арифметическую операцию (+,-,/,*): ", sc);
        if (lsOper.isEmpty()) {
            System.out.println("Некорректное значение");
            return;
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
                    return;
                }
                ldRes = ldVar1 / ldVar2;

                break;
        }
        System.out.printf("\nРезультат: %.4f", ldRes);

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


}
