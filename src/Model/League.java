package Model;

import Enums.ELeagueType;
import Interfaces.ILeagues;

import java.util.List;

public class League implements ILeagues {

    private ELeagueType leagueName;

    private List<User> userList;

    private Language language;

    public League(ELeagueType leagueName, List<User> userList, Language language) {
        this.leagueName = leagueName;
        this.userList = userList;
        this.language = language;
    }


    @Override
    public List<User> getRankings() {
        return null;
    }

    @Override
    public void upgradeRank() {

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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
