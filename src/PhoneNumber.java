import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

    public static void readPhoneNumber() {
        try (FileInputStream file = new FileInputStream("./files/phone.txt")) {
            byte[] buffer = new byte[file.available()];
            file.read(buffer);

            Pattern pattern = Pattern.compile("(\\(\\d{3}\\)\\s\\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})");
            Matcher matcher = pattern.matcher(new String(buffer));

           while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class PhoneNumberTest {
    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.readPhoneNumber();
    }
}
