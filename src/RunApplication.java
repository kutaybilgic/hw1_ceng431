import Factory.LanguageFactory;
import Factory.UserFactory;
import Model.User;

import java.io.IOException;
import java.util.List;

public class RunApplication {

    public void runApplication(){


        LanguageFactory languageFactory = new LanguageFactory();
        languageFactory.createAllLanguage();

        UserFactory userFactory = new UserFactory();

        List<User> userList = userFactory.createUsers("./users.csv");

        System.out.println(userList.size());

    }





}
