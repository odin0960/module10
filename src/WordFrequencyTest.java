public class WordFrequencyTest {
    public static void main(String[] args) {
        WordFrequency fileWords = new WordFrequency();
        String fileName = "./files/words.txt";

        fileWords.countWords(fileWords.readFile(fileName));
    }
}
