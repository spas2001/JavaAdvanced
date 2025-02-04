import Sweet.Candy;
import Sweet.Cook;
import Sweet.JellyBean;
import Sweet.SweetItem;

import java.util.Random;
import java.util.Scanner;

/**
 * Java Advanced Example #3
 *
 * @author Булгаков В.В. 04.02.2025
 * 1. Массив размерностью 20
 * - Он заполняется случайными целыми числами от -10 до 10
 * - Нужно найти максимальный отрицательный и минимальный положительный элементы массива
 * - Поменять их местами.
 * @see #doArrayRandomTest(Scanner)
 * 2. Формируется сладкий подарок.
 * - Он может включать в себя разные сладости (Candy, Jellybean, etc.)
 * - У каждой сладости есть название, вес, цена и свой уникальный параметр
 * - Необходимо собрать подарок из сладостей
 * - Найти общий вес подарка, общую стоимость подарка
 * - Вывести на консоль информацию о всех сладостях в подарке
 * @see #doSweetBox(Scanner)
 */

public class ArrayAndSweetBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Выберем требуемый функционал
        System.out.println("Выберите тип задачи: (1 - массив случайных чисел, 2 - коробка со сладостями): ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    //массив случайных чисел
                    int liResArr = doArrayRandomTest(sc);
                    break;
                case 2:
                    //коробка со сладостями
                    int liResSweetBox = doSweetBox(sc);
                    break;
                default:
                    System.out.println("Некорректная операция");
            }
        } else {
            System.out.println("Некорректная операция");
        }
    }

    public static int doArrayRandomTest(Scanner sc) {
        int[] arrRand = new int[20];
        int minValue = -11, maxValue = 10;
        int liMin = 0, liMax = 0;
        Random rand = new Random();
        System.out.println("Массив");
        for (int i = 0; i < arrRand.length; i++) {
            arrRand[i] = rand.nextInt(21) - 10;
            //Нужно найти максимальный отрицательный и минимальный положительный элементы массива
            System.out.print(" " + arrRand[i]);
            if ((arrRand[i] > minValue) && (arrRand[i] < 0)) {
                minValue = arrRand[i];
                liMin = i;
            }
            if ((arrRand[i] < maxValue) && (arrRand[i] > 0)) {
                maxValue = arrRand[i];
                liMax = i;
            }
        }
        //1. Выведите максимальный отрицательный и минимальный положительный элемент массива. 0 - не учитываем
        System.out.println("\nМаксимальный отрицательный элемент массива: " + minValue + ", минимальный положительный элемент: " + maxValue);
        //2. Поменять их местами
        System.out.println("Меняем местами " + liMin + " элемент массива и " + liMax + " элемент массива");
        arrRand[liMin] = maxValue;
        arrRand[liMax] = minValue;
        System.out.println("Массив");
        for (int j : arrRand) {
            System.out.print(" " + j);
        }
        return 0;
    }

    public static int doSweetBox(Scanner sc) {
        Candy candy1 = new Candy("Мишка", 0.1, 99.2,"S");
        Candy candy2 = new Candy("Рябинка", 0.3, 77.2,"L");
        JellyBean bean1 = new JellyBean("Червячки", 0.3, 15.1,"light");
        JellyBean bean2 = new JellyBean("Шишечки", 0.5, 35.3,"hard");
        Cook cook1 = new Cook("Овсяное",1.7, 27.8,"yes" );
        SweetItem [] sweetBox =  {candy1, candy2, candy1, bean1, bean2, cook1, cook1};
        double sumWeight = 0;
        double totalPrice = 0;
        System.out.println("Коробка со сладостями \nCостав: ");
        for (SweetItem sweetItem : sweetBox) {
            sumWeight += sweetItem.getWeight();
            totalPrice += sweetItem.getPrice();
            System.out.println(sweetItem.toString());
        }
        System.out.println("\nОбщий вес подарка "+ sumWeight + ", общая стоимость "+ totalPrice);
        return 0;
    }


}

