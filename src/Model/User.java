package Model;

import Enums.ELeagueType;

public class User {
    private String username;

    private String password;

    private Language selectedLanguage;

    private Integer unitCount;

    private Integer streak;

    private Integer totalPoints;

    private ELeagueType currentLeague;

    public User(String username, String password, Language selectedLanguage, Integer unitCount, Integer streak) {
        this.username = username;
        this.password = password;
        this.selectedLanguage = selectedLanguage;
        this.unitCount = unitCount;
        this.streak = streak;
        this.totalPoints = 0;
        this.currentLeague = ELeagueType.BRONZE;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Language getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(Language selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public Integer getCurrentUnit() {
        return unitCount;
    }

    public void setCurrentUnit(Integer unitCount) {
        this.unitCount = unitCount;
    }

    public Integer getStreak() {
        return streak;
    }

    public void setStreak(Integer streak) {
        this.streak = streak;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public ELeagueType getCurrentLeague() {
        return currentLeague;
    }

    public void setCurrentLeague(ELeagueType currentLeague) {
        this.currentLeague = currentLeague;
    }
}
