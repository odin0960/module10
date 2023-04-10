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
        // формує мапу - "слово - кількость"
        // та виводить у консоль
        ArrayList<String> wordUnique = new ArrayList<>();
        for (String word : words) {
            if (!wordUnique.contains(word))
                wordUnique.add(word);
        }

        ArrayList<Integer> countWords = new ArrayList<>();
        for (int i = 0; i < wordUnique.size(); i++) {
            int count = 0;
            for (String word : words) {
                if (wordUnique.get(i).equals(word))
                    count++;
            }
            countWords.add(count);
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordUnique.size(); i++) {
            map.put(wordUnique.get(i), countWords.get(i));
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (Map.Entry<String, Integer> entry: list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

class WordFrequencyTest {
    public static void main(String[] args) {
        WordFrequency fileWords = new WordFrequency();

        fileWords.countWords(fileWords.readFile("words.txt"));
    }
}