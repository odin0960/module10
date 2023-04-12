public class TextToJsonTest {
    public static void main(String[] args) {
        TextToJson test = new TextToJson();
        test.readTextToObject("./files/file.txt");
        test.writeObjectToJson();

    }
}
