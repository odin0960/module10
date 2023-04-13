import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class WordFrequency {

    private String fileName;

    public String[] readFile(String fileName) {         //повертає текст у вигляді масиву слів
        try (FileInputStream file = new FileInputStream(fileName)) {
            StringBuilder str = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                str.append(line).append(" ");
            }
            String[] words = str.toString().strip().split("\\s*(\\s)\\s*");

            return words;                    // весь текст з файлу у вигляді масиву слів
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void countWords(String[] words) {
        // рахує кількість кожного слова у тексті (масиві),
        // формує мапу - "слово - кількість" та виводить у консоль
        ArrayList<String> key = new ArrayList<>();   // колекція унікальних слів
        for (String word : words) {
            if (!key.contains(word))
                key.add(word);
        }

        ArrayList<Integer> value = new ArrayList<>();  // колекція кількостей слів у тексті (індекси співпадають з колекцією слів)
        for (int i = 0; i < key.size(); i++) {
            int count = 0;
            for (String word : words) {
                if (key.get(i).equals(word))
                    count++;
            }
            value.add(count);
        }

        Map<String, Integer> map = new HashMap<>();  // мапа "слово - кількість"
        for (int i = 0; i < key.size(); i++) {
            map.put(key.get(i), value.get(i));
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());   // мапа у вигляді списка
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));         // сортування списка з мапи по значенню
        for (Map.Entry<String, Integer> entry : list) {                            // та виведення у консоль кожної пари
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
// інші робочі варіанти сортування та виведення у консоль:
//
//      map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .forEach(System.out::println);

//        map.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .forEach(value -> System.out.println(value.getKey() + " " + value.getValue()));        }
}

