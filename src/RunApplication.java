import Enums.ELanguage;
import Factory.LanguageFactory;
import Factory.LeagueFactory;
import Factory.UserFactory;
import Model.Language;
import Model.League;
import Model.Unit;
import Model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RunApplication {

    public void runApplication(){

        //Eğer language.csv yoksa tüm Language'ları oluşturur ve içerisindeki Unit,Quiz ve question sayısını belirleyip csv'ye yazar.
        LanguageFactory languageFactory = new LanguageFactory();
        languageFactory.createAllLanguage("./languages.csv");

        //Tüm userları csv den çekip oluşturur. Dil random seçilir ve dil içerisindeki unit,quiz,question sayısı csv den çekilip oluşturulur.
        UserFactory userFactory = new UserFactory();
        List<User> userList = userFactory.createUsers("./users.csv");
        System.out.println(userList.size());

        LeagueFactory leagueFactory = new LeagueFactory();
        Map<ELanguage, List<League>> leagueMap = leagueFactory.createLeagues(userList);
        deleteFile();

        // ELanguage enum'unuzdaki dillerin listesi
        List<ELanguage> languages = Arrays.asList(ELanguage.values());


        for (List<League> leagues : leagueMap.values()) {
            for (League league : leagues) {
                System.out.println(league.getLeagueName() + ": " + league.getUserList().size());
            }
        }
    }

    public void deleteFile(){
        File newFile = new File("./users.csv");

        try (InputStream in = new FileInputStream("users2.csv");
             OutputStream out = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File oldFile = new File("./users2.csv");
        if (oldFile.exists()) {
            oldFile.delete();
        }
    }





}
