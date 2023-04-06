package Factory;

import Enums.ELanguage;
import Enums.ELeagueType;
import Model.League;
import Model.User;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LeagueFactory {

    //Her dil için tüm liglerden League classı oluştur
    //Sonra kullanıcı listesi alıp liglerin içine at


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

        for (User user: userList) {
            switch (user.getSelectedLanguage().getLanguageName()) {
                case GERMAN -> germanList.add(user);
                case ITALIAN -> italianList.add(user);
                case SPANISH -> spanishList.add(user);
                case TURKISH -> turkishList.add(user);
            }
        }


        ELanguage[] languages = ELanguage.values();
        for (int i = 0 ; i < 4 ; i++) {
               switch (languages[i]) {
                   case GERMAN:
                       League leagueGermanBronze = new League(ELeagueType.BRONZE, germanList, languages[i]);
                       League leagueGermanSilver = new League(ELeagueType.SILVER, new ArrayList<User>(), languages[i]);
                       League leagueGermanGold = new League(ELeagueType.GOLD, new ArrayList<User>(), languages[i]);
                       League leagueGermanSapphire = new League(ELeagueType.SAPPHIRE, new ArrayList<User>(), languages[i]);
                       League leagueGermanRuby = new League(ELeagueType.RUBY, new ArrayList<User>(), languages[i]);
                       leagueGermanBronze.getRankings();
                       List<User> upgradedBronzeGermanList = leagueGermanBronze.upgradeRank();

                       for(User userBronze: upgradedBronzeGermanList) {
                           leagueGermanSilver.getUserList().add(userBronze);
                           leagueGermanBronze.getUserList().remove(userBronze);
                           userBronze.setCurrentLeague(ELeagueType.SILVER);
                       }

                       leagueGermanSilver.getRankings();
                       List<User> upgradedSilverGermanList = leagueGermanSilver.upgradeRank();
                       for(User userSilver: upgradedSilverGermanList) {
                           leagueGermanGold.getUserList().add(userSilver);
                           leagueGermanSilver.getUserList().remove(userSilver);
                           userSilver.setCurrentLeague(ELeagueType.GOLD);
                       }

                       leagueGermanGold.getRankings();
                       List<User> upgradedGoldGermanList = leagueGermanGold.upgradeRank();
                       for(User userGold: upgradedGoldGermanList) {
                           leagueGermanSapphire.getUserList().add(userGold);
                           leagueGermanGold.getUserList().remove(userGold);
                           userGold.setCurrentLeague(ELeagueType.SAPPHIRE);
                       }

                       leagueGermanSapphire.getRankings();
                       List<User> upgradedSapphireGermanList = leagueGermanSapphire.upgradeRank();
                       for(User userSapphire: upgradedSapphireGermanList) {
                           leagueGermanRuby.getUserList().add(userSapphire);
                           leagueGermanSapphire.getUserList().remove(userSapphire);
                           userSapphire.setCurrentLeague(ELeagueType.RUBY);
                       }



                       germanLeagueList.add(leagueGermanBronze);
                       germanLeagueList.add(leagueGermanSilver);
                       germanLeagueList.add(leagueGermanGold);
                       germanLeagueList.add(leagueGermanSapphire);
                       germanLeagueList.add(leagueGermanRuby);

                       leagueMap.put(languages[i], germanLeagueList);
                       break;

                   case ITALIAN:
                       League leagueItalianBronze = new League(ELeagueType.BRONZE, italianList, languages[i]);
                       League leagueItalianSilver = new League(ELeagueType.SILVER, new ArrayList<User>(), languages[i]);
                       League leagueItalianGold = new League(ELeagueType.GOLD, new ArrayList<User>(), languages[i]);
                       League leagueItalianSapphire = new League(ELeagueType.SAPPHIRE, new ArrayList<User>(), languages[i]);
                       League leagueItalianRuby = new League(ELeagueType.RUBY, new ArrayList<User>(), languages[i]);
                       leagueItalianBronze.getRankings();
                       List<User> upgradedBronzeItalianList = leagueItalianBronze.upgradeRank();
                       for(User userBronze: upgradedBronzeItalianList) {
                           leagueItalianSilver.getUserList().add(userBronze);
                           leagueItalianBronze.getUserList().remove(userBronze);
                           userBronze.setCurrentLeague(ELeagueType.SILVER);
                       }

                       leagueItalianSilver.getRankings();
                       List<User> upgradedSilverItalianList = leagueItalianSilver.upgradeRank();
                       for(User userSilver: upgradedSilverItalianList) {
                           leagueItalianGold.getUserList().add(userSilver);
                           leagueItalianSilver.getUserList().remove(userSilver);
                           userSilver.setCurrentLeague(ELeagueType.GOLD);
                       }

                       leagueItalianGold.getRankings();
                       List<User> upgradedGoldItalianList = leagueItalianGold.upgradeRank();
                       for(User userGold: upgradedGoldItalianList) {
                           leagueItalianSapphire.getUserList().add(userGold);
                           leagueItalianGold.getUserList().remove(userGold);
                           userGold.setCurrentLeague(ELeagueType.SAPPHIRE);
                       }

                       leagueItalianSapphire.getRankings();
                       List<User> upgradedSapphireItalianList = leagueItalianSapphire.upgradeRank();
                       for(User userSapphire: upgradedSapphireItalianList) {
                           leagueItalianRuby.getUserList().add(userSapphire);
                           leagueItalianSapphire.getUserList().remove(userSapphire);
                           userSapphire.setCurrentLeague(ELeagueType.RUBY);
                       }



                       italianLeagueList.add(leagueItalianBronze);
                       italianLeagueList.add(leagueItalianSilver);
                       italianLeagueList.add(leagueItalianGold);
                       italianLeagueList.add(leagueItalianSapphire);
                       italianLeagueList.add(leagueItalianRuby);

                       leagueMap.put(languages[i], italianLeagueList);
                       break;


                   case SPANISH:
                       League leagueSpanishBronze = new League(ELeagueType.BRONZE, spanishList, languages[i]);
                       League leagueSpanishSilver = new League(ELeagueType.SILVER, new ArrayList<User>(), languages[i]);
                       League leagueSpanishGold = new League(ELeagueType.GOLD, new ArrayList<User>(), languages[i]);
                       League leagueSpanishSapphire = new League(ELeagueType.SAPPHIRE, new ArrayList<User>(), languages[i]);
                       League leagueSpanishRuby = new League(ELeagueType.RUBY, new ArrayList<User>(), languages[i]);

                       leagueSpanishBronze.getRankings();
                       List<User> upgradedBronzeSpanishList = leagueSpanishBronze.upgradeRank();
                       for(User userBronze: upgradedBronzeSpanishList) {
                           leagueSpanishSilver.getUserList().add(userBronze);
                           leagueSpanishBronze.getUserList().remove(userBronze);
                           userBronze.setCurrentLeague(ELeagueType.SILVER);
                       }

                       leagueSpanishSilver.getRankings();
                       List<User> upgradedSilverSpanishList = leagueSpanishSilver.upgradeRank();
                       for(User userSilver: upgradedSilverSpanishList) {
                           leagueSpanishGold.getUserList().add(userSilver);
                           leagueSpanishSilver.getUserList().remove(userSilver);
                           userSilver.setCurrentLeague(ELeagueType.GOLD);
                       }

                       leagueSpanishGold.getRankings();
                       List<User> upgradedGoldSpanishList = leagueSpanishGold.upgradeRank();
                       for(User userGold: upgradedGoldSpanishList) {
                           leagueSpanishSapphire.getUserList().add(userGold);
                           leagueSpanishGold.getUserList().remove(userGold);
                           userGold.setCurrentLeague(ELeagueType.SAPPHIRE);
                       }

                       leagueSpanishSapphire.getRankings();
                       List<User> upgradedSapphireSpanishList = leagueSpanishSapphire.upgradeRank();
                       for(User userSapphire: upgradedSapphireSpanishList) {
                           leagueSpanishRuby.getUserList().add(userSapphire);
                           leagueSpanishSapphire.getUserList().remove(userSapphire);
                           userSapphire.setCurrentLeague(ELeagueType.RUBY);
                       }

                       spanishLeagueList.add(leagueSpanishBronze);
                       spanishLeagueList.add(leagueSpanishSilver);
                       spanishLeagueList.add(leagueSpanishGold);
                       spanishLeagueList.add(leagueSpanishSapphire);
                       spanishLeagueList.add(leagueSpanishRuby);

                       leagueMap.put(languages[i], spanishLeagueList);
                       break;

                   case TURKISH:
                       League leagueTurkishBronze = new League(ELeagueType.BRONZE, turkishList, languages[i]);
                       League leagueTurkishSilver = new League(ELeagueType.SILVER, new ArrayList<User>(), languages[i]);
                       League leagueTurkishGold = new League(ELeagueType.GOLD, new ArrayList<User>(), languages[i]);
                       League leagueTurkishSapphire = new League(ELeagueType.SAPPHIRE, new ArrayList<User>(), languages[i]);
                       League leagueTurkishRuby = new League(ELeagueType.RUBY, new ArrayList<User>(), languages[i]);
                       leagueTurkishBronze.getRankings();
                       List<User> upgradedBronzeTurkishList = leagueTurkishBronze.upgradeRank();
                       for(User userBronze: upgradedBronzeTurkishList) {
                           leagueTurkishSilver.getUserList().add(userBronze);
                           leagueTurkishBronze.getUserList().remove(userBronze);
                           userBronze.setCurrentLeague(ELeagueType.SILVER);
                       }

                       leagueTurkishSilver.getRankings();
                       List<User> upgradedSilverTurkishList = leagueTurkishSilver.upgradeRank();
                       for(User userSilver: upgradedSilverTurkishList) {
                           leagueTurkishGold.getUserList().add(userSilver);
                           leagueTurkishSilver.getUserList().remove(userSilver);
                           userSilver.setCurrentLeague(ELeagueType.GOLD);
                       }

                       leagueTurkishGold.getRankings();
                       List<User> upgradedGoldTurkishList = leagueTurkishGold.upgradeRank();
                       for(User userGold: upgradedGoldTurkishList) {
                           leagueTurkishSapphire.getUserList().add(userGold);
                           leagueTurkishGold.getUserList().remove(userGold);
                           userGold.setCurrentLeague(ELeagueType.SAPPHIRE);
                       }

                       leagueTurkishSapphire.getRankings();
                       List<User> upgradedSapphireTurkishList = leagueTurkishSapphire.upgradeRank();
                       for(User userSapphire: upgradedSapphireTurkishList) {
                           leagueTurkishRuby.getUserList().add(userSapphire);
                           leagueTurkishSapphire.getUserList().remove(userSapphire);
                           userSapphire.setCurrentLeague(ELeagueType.RUBY);
                       }

                       turkishLeagueList.add(leagueTurkishBronze);
                       turkishLeagueList.add(leagueTurkishSilver);
                       turkishLeagueList.add(leagueTurkishGold);
                       turkishLeagueList.add(leagueTurkishSapphire);
                       turkishLeagueList.add(leagueTurkishRuby);

                       leagueMap.put(languages[i], turkishLeagueList);
                       break;
               }
        }
        return leagueMap;
    }




}
