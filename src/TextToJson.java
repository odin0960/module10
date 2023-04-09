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

        File fileJson = new File("file.json");
        try(FileWriter writer = new FileWriter(fileJson)){
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    }


    class User implements Serializable {
        private String name;
        private int age;

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    class TextToJsonTest {
        public static void main(String[] args) {
            TextToJson test = new  TextToJson();
            test.readTextToObject("file.txt");
            test.writeObjectToJson();

        }
    }
