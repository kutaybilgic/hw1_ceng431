package Factory;

import Model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserFactory {

    public List<User> createUsers(String filePath){
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while (line != null) {
                String[] fields = line.split(";");
                String username = fields[0];
                String password = fields[1];

                LanguageFactory languageFactory = new LanguageFactory();
                var selectedLanguage = languageFactory.createLanguage();

                Random random = new Random();
                var streakNumber = random.nextInt(0, 365);

                User user = new User(username, password, selectedLanguage, selectedLanguage.getUnitList().size(),
                        streakNumber);
                userList.add(user);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;

    }


}
