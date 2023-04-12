public class WordFrequencyTest {
    public static void main(String[] args) {
        WordFrequency fileWords = new WordFrequency();

        fileWords.countWords(fileWords.readFile("./files/words.txt"));
    }
}
