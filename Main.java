import java.util.Arrays; //Для работы с массивами
import java.util.Comparator; //Необходим для сравнения объектов
import java.util.Map; //Необходим для работы с отображением
import java.util.Scanner; //Для чтения ввода с клавиатуры
import java.util.stream.Collectors; //Для операции с потоками данных

//Основной класс
public class Main {
    public static void main(String[] args) {
        //Создаем объект для считывания ввода с клавиатуры, выводим сообщение о просьбе ввести текст и принимаем текст на следующей строке
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String inputText = scanner.nextLine();

        // Разбиваем текст на слова, разделенные пробелами
        String[] words = inputText.split(" ");

        // Создаем поток слов, фильтруем их и убираем лишние символы
        Map<String, Long> wordFrequencyMap = Arrays.stream(words)
                .map(word -> word.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase())
                .filter(word -> word.length() > 0)
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));

        // Сортируем слова по убыванию частоты и выводим результаты
        wordFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
