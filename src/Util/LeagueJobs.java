package Util;

import Enums.ELanguage;
import Enums.ELeagueType;
import Model.League;
import Model.User;

import java.util.List;
import java.util.Map;

public class LeagueJobs {

    public void addLeaguesToListAndMap(Map<ELanguage, List<League>> leagueMap, ELanguage language, List<League> leagueList, League bronze, League silver, League golden, League sapphire, League ruby) {
        leagueList.add(bronze);
        leagueList.add(silver);
        leagueList.add(golden);
        leagueList.add(sapphire);
        leagueList.add(ruby);

        leagueMap.put(language, leagueList);
    }

    public void updateLeague(League bronze, League silver, League golden, League sapphire, League ruby) {

        bronze.getRankings();

        List<User> upgradedBronzeList = bronze.upgradeRank();

        for (User user : upgradedBronzeList) {
            silver.getUserList().add(user);
            bronze.getUserList().remove(user);
            user.setCurrentLeague(ELeagueType.SILVER);
        }

        silver.getRankings();
        List<User> upgradedSilverList = silver.upgradeRank();

        for (User user : upgradedSilverList) {
            golden.getUserList().add(user);
            silver.getUserList().remove(user);
            user.setCurrentLeague(ELeagueType.GOLD);
        }

        golden.getRankings();
        List<User> upgradedGoldenList = golden.upgradeRank();

        for (User user : upgradedGoldenList) {
            sapphire.getUserList().add(user);
            golden.getUserList().remove(user);
            user.setCurrentLeague(ELeagueType.SAPPHIRE);
        }

        sapphire.getRankings();
        List<User> upgradedSapphireList = sapphire.upgradeRank();

        for (User user : upgradedSapphireList) {
            ruby.getUserList().add(user);
            sapphire.getUserList().remove(user);
            user.setCurrentLeague(ELeagueType.RUBY);
        }

    }
}
