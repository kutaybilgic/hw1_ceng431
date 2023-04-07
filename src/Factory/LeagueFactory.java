package Factory;

import Enums.ELanguage;
import Enums.ELeagueType;
import Model.League;
import Model.User;
import Util.LeagueJobs;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LeagueFactory {

    private final LeagueJobs leagueJobs = new LeagueJobs();


    public Map<ELanguage, List<League>> createLeagues(List<User> userList) {
        List<User> spanishList = new ArrayList<>();
        List<User> turkishList = new ArrayList<>();
        List<User> italianList = new ArrayList<>();
        List<User> germanList = new ArrayList<>();

        List<League> germanLeagueList = new ArrayList<>();
        List<League> italianLeagueList = new ArrayList<>();
        List<League> spanishLeagueList = new ArrayList<>();
        List<League> turkishLeagueList = new ArrayList<>();

        Map<ELanguage, List<League>> leagueMap = new LinkedHashMap<>();

        ELanguage[] languages = ELanguage.values();

        for (User user: userList) {
            switch (user.getSelectedLanguage().getLanguageName()) {
                case GERMAN -> germanList.add(user);
                case ITALIAN -> italianList.add(user);
                case SPANISH -> spanishList.add(user);
                case TURKISH -> turkishList.add(user);
            }
        }

        for (int i = 0 ; i < 4 ; i++) {
               switch (languages[i]) {
                   case GERMAN:
                       League leagueGermanBronze = new League(ELeagueType.BRONZE, germanList, languages[i]);
                       League leagueGermanSilver = new League(ELeagueType.SILVER, new ArrayList<User>(), languages[i]);
                       League leagueGermanGold = new League(ELeagueType.GOLD, new ArrayList<User>(), languages[i]);
                       League leagueGermanSapphire = new League(ELeagueType.SAPPHIRE, new ArrayList<User>(), languages[i]);
                       League leagueGermanRuby = new League(ELeagueType.RUBY, new ArrayList<User>(), languages[i]);

                       leagueJobs.updateLeague(leagueGermanBronze, leagueGermanSilver, leagueGermanGold, leagueGermanSapphire, leagueGermanRuby);
                       leagueJobs.addLeaguesToListAndMap(leagueMap, languages[i], germanLeagueList, leagueGermanBronze, leagueGermanSilver, leagueGermanGold, leagueGermanSapphire, leagueGermanRuby);

                       break;

                   case ITALIAN:
                       League leagueItalianBronze = new League(ELeagueType.BRONZE, italianList, languages[i]);
                       League leagueItalianSilver = new League(ELeagueType.SILVER, new ArrayList<User>(), languages[i]);
                       League leagueItalianGold = new League(ELeagueType.GOLD, new ArrayList<User>(), languages[i]);
                       League leagueItalianSapphire = new League(ELeagueType.SAPPHIRE, new ArrayList<User>(), languages[i]);
                       League leagueItalianRuby = new League(ELeagueType.RUBY, new ArrayList<User>(), languages[i]);

                       leagueJobs.updateLeague(leagueItalianBronze, leagueItalianSilver, leagueItalianGold, leagueItalianSapphire, leagueItalianRuby);
                       leagueJobs.addLeaguesToListAndMap(leagueMap, languages[i], italianLeagueList, leagueItalianBronze, leagueItalianSilver, leagueItalianGold, leagueItalianSapphire, leagueItalianRuby);

                       break;

                   case SPANISH:
                       League leagueSpanishBronze = new League(ELeagueType.BRONZE, spanishList, languages[i]);
                       League leagueSpanishSilver = new League(ELeagueType.SILVER, new ArrayList<User>(), languages[i]);
                       League leagueSpanishGold = new League(ELeagueType.GOLD, new ArrayList<User>(), languages[i]);
                       League leagueSpanishSapphire = new League(ELeagueType.SAPPHIRE, new ArrayList<User>(), languages[i]);
                       League leagueSpanishRuby = new League(ELeagueType.RUBY, new ArrayList<User>(), languages[i]);

                       leagueJobs.updateLeague(leagueSpanishBronze, leagueSpanishSilver, leagueSpanishGold, leagueSpanishSapphire, leagueSpanishRuby);
                       leagueJobs.addLeaguesToListAndMap(leagueMap, languages[i], spanishLeagueList, leagueSpanishBronze, leagueSpanishSilver, leagueSpanishGold, leagueSpanishSapphire, leagueSpanishRuby);

                       break;

                   case TURKISH:
                       League leagueTurkishBronze = new League(ELeagueType.BRONZE, turkishList, languages[i]);
                       League leagueTurkishSilver = new League(ELeagueType.SILVER, new ArrayList<User>(), languages[i]);
                       League leagueTurkishGold = new League(ELeagueType.GOLD, new ArrayList<User>(), languages[i]);
                       League leagueTurkishSapphire = new League(ELeagueType.SAPPHIRE, new ArrayList<User>(), languages[i]);
                       League leagueTurkishRuby = new League(ELeagueType.RUBY, new ArrayList<User>(), languages[i]);

                       leagueJobs.updateLeague(leagueTurkishBronze, leagueTurkishSilver, leagueTurkishGold, leagueTurkishSapphire, leagueTurkishRuby);
                       leagueJobs.addLeaguesToListAndMap(leagueMap, languages[i], turkishLeagueList, leagueTurkishBronze, leagueTurkishSilver, leagueTurkishGold, leagueTurkishSapphire, leagueTurkishRuby);

                       break;
               }
        }
        return leagueMap;
    }




}
