package Model;

import Enums.ELanguage;
import Enums.ELeagueType;
import Interfaces.ILeagues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class League implements ILeagues {

    private ELeagueType leagueName;

    private List<User> userList;

    private ELanguage language;

    public League(ELeagueType leagueName, List<User> userList, ELanguage language) {
        this.leagueName = leagueName;
        this.userList = userList;
        this.language = language;
    }



    @Override
    public void getRankings() {
        List<User> sortedList = new ArrayList<>(userList);
        sortedList.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int totalPointsComparison = Integer.compare(user2.getTotalPoints(), user1.getTotalPoints());
                if (totalPointsComparison != 0) {
                    return totalPointsComparison;
                }
                return Integer.compare(user2.getStreak(), user1.getStreak());
            }
        });
        userList = sortedList;
    }

    @Override
    public List<User> upgradeRank() {
        List<User> upgradesUserList = new ArrayList<>();
        if (this.getLeagueName().equals(ELeagueType.BRONZE)) {
            int countNumber = Math.min(userList.size(), 15);
            for (int i = 0 ; i < countNumber ; i++) {
                upgradesUserList.add(userList.get(i));
            }
        }

        else if (this.getLeagueName().equals(ELeagueType.SILVER)) {
            int countNumber = Math.min(userList.size(), 10);
            for (int i = 0 ; i < countNumber ; i++) {
                upgradesUserList.add(userList.get(i));
            }
        }
        else if (this.getLeagueName().equals(ELeagueType.GOLD)) {
            int countNumber = Math.min(userList.size(), 5);
            for (int i = 0 ; i < countNumber ; i++) {
                if (userList.get(i).getStreak() > 6) {
                    upgradesUserList.add(userList.get(i));
                }
            }
        }

        else if (this.getLeagueName().equals(ELeagueType.SAPPHIRE)) {
            for (User user : userList) {
                if ((user.getStreak() > 29) && ((user.getTotalPoints() > 5000) || (user.getCurrentUnit() > 9))) {
                    upgradesUserList.add(user);
                }
            }
        }
        return upgradesUserList;
    }

    public ELanguage getLanguage() {
        return language;
    }

    public void setLanguage(ELanguage language) {
        this.language = language;
    }

    public ELeagueType getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(ELeagueType leagueName) {
        this.leagueName = leagueName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
