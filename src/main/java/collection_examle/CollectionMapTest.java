package collection_examle;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Java Advanced Example #5
 *
 * @author Булгаков В.В. 07.02.2025
 * Есть входной файл с набором слов, написанных через пробел
 * Необходимо:
 * - Прочитать слова из файла.
 * - Отсортировать в алфавитном порядке.
 * - Посчитать сколько раз каждое слово встречается в файле
 * - Вывести статистику на консоль
 * - Найти слово с максимальным количеством повторений
 * - Вывести на консоль это слово и сколько раз оно встречается в файле
 */
public class CollectionMapTest {
    public static void main(String[] args) {
        //Считаем строку из файла
        String lsIn = readFile(".//src//main//resources//test.txt");
        //Распарсим в массив
        List<String> lsList = Arrays.asList(lsIn.split(" "));
        //Выведем полученный массив на экран
        System.out.println("Входной массив :" + lsList);
        //Отсортируем в алфавитном порядке
        Collections.sort(lsList);
        //Выведем полученный массив на экран
        System.out.println("Отсортированный массив: " + lsList);
        //Создадим HashMap, чтобы посчитать значения
        Map<String, Long> frequency =
                lsList.stream().collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));
        long maxValue = 0;
        String maxKey = null;
        System.out.println("Статистика повторений: " + frequency.keySet());
        for (Map.Entry<String, Long> entry : frequency.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
                maxKey = key;
            }
            System.out.println(key + " : " + value);
        }

        System.out.println("Слово с максимальным количеством повторений: " + maxKey);
        System.out.println("Слово:" + maxKey + " Количество повторений: " + maxValue);

    }

    public static String readFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            String content = Files.readAllLines(path).get(0);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}