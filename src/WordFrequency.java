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

            return words;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void countWords(String[] words) {
        // рахує кількість кожного слова у тексті (масиві),
        // формує мапу - "слово - кількость" та виводить у консоль
        ArrayList<String> key = new ArrayList<>();
        for (String word : words) {
            if (!key.contains(word))
                key.add(word);
        }

        ArrayList<Integer> value = new ArrayList<>();
        for (int i = 0; i < key.size(); i++) {
            int count = 0;
            for (String word : words) {
                if (key.get(i).equals(word))
                    count++;
            }
            value.add(count);
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            map.put(key.get(i), value.get(i));
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());

//      map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .forEach(System.out::println);
        }
    }
}

class WordFrequencyTest {
    public static void main(String[] args) {
        WordFrequency fileWords = new WordFrequency();

        fileWords.countWords(fileWords.readFile("./files/words.txt"));
    }
}