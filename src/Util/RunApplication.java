package Util;

import Enums.ELanguage;
import Factory.LanguageFactory;
import Factory.LeagueFactory;
import Factory.UserFactory;
import Model.League;
import Model.User;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static Util.FileDeleter.deleteFile;

public class RunApplication {

    public void runApplication(){

        //If language.csv does not exist, it creates all Languages and determines the number of Unit, Quiz and question in it and writes it to csv.
        LanguageFactory languageFactory = new LanguageFactory();
        languageFactory.createAllLanguage("./languages.csv");

        //It pulls all users from csv and creates them. The language is chosen randomly and the number of units, quizzes, quests in the language is drawn from csv and created.
        UserFactory userFactory = new UserFactory();
        List<User> userList = userFactory.createUsers("./users.csv");

        //After users are created, it creates leagues for all users, sorts users according to their scores and updates them to leagues.
        LeagueFactory leagueFactory = new LeagueFactory();
        Map<ELanguage, List<League>> leagueMap = leagueFactory.createLeagues(userList);

        //It deletes old csv file and creates new csv file.
        deleteFile("./users.csv", "users2.csv", "./users2.csv");

        // ELanguage enum'unuzdaki dillerin listesi
        List<ELanguage> languages = Arrays.asList(ELanguage.values());


        for (List<League> leagues : leagueMap.values()) {
            for (League league : leagues) {
                System.out.println(league.getLeagueName() + ": " + league.getUserList().size());
            }
        }


    }
}
