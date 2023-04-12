import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextToJson {

    ArrayList<User> users = new ArrayList<>();

    public void readTextToObject(String fileName) {    //file.txt

        try (FileInputStream file = new FileInputStream(fileName)) {

            Scanner scanner = new Scanner(file);
            String lineTmp = scanner.nextLine();

            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split("\\s");
                users.add(new User(line[0], Integer.parseInt(line[1])));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void writeObjectToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(users);

        File fileJson = new File("./files/file.json");
        try(FileWriter writer = new FileWriter(fileJson)){
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


