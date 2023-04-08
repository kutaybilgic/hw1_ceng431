package Factory;

import Enums.ELanguage;
import Model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserFactory {

    public List<User> createUsers(String filePath) {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             PrintWriter writer = new PrintWriter(new FileWriter("users2.csv"))) {

            String line = reader.readLine();
            while (line != null) {
                Random random = new Random();
                String[] fields = line.split(";");
                String username = fields[0];
                String password = fields[1];

                ELanguage[] languages = ELanguage.values();
                ELanguage randomLanguage = languages[random.nextInt(languages.length)];

                LanguageFactory languageFactory = new LanguageFactory();
                var selectedLanguage = languageFactory.getCreatedLanguages("./languages.csv", randomLanguage);

                int streakNumber = random.nextInt(0, 365);

                User user = new User(username, password, selectedLanguage, selectedLanguage.getCurrentUnit(),
                        streakNumber);
                user.setTotalPoints(selectedLanguage.getTotalPoint());
                user.setSolvedQuizzes(selectedLanguage.getSolvedQuizzes());
                userList.add(user);

                String userInfo = user.getUsername() + ";" + user.getPassword() + ";" +
                        user.getSelectedLanguage().getLanguageName() + ";" + user.getCurrentUnit() + ";" +
                        user.getSolvedQuizzes() + ";" + user.getTotalPoints();

                writer.println(userInfo);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }



}
