import Factory.UserFactory;
import Model.User;

import java.util.List;

public class RunApplication {

    public void runApplication() {

        UserFactory userFactory = new UserFactory();

        List<User> userList = userFactory.createUsers("./users.csv");

        System.out.println(userList.size());

    }





}
