package Util;

import Enums.ELanguage;
import Enums.ELeagueType;
import Model.Language;
import Model.League;
import Model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QueryGenerator {


    public void findMaxPointForUsers(List<User> userList) {

        int max_point = 0;

        List<User> maxPointUserList = new ArrayList<>();

        for (User user : userList) {
            if (user.getTotalPoints() >= max_point) {
                max_point = user.getTotalPoints();

                if (maxPointUserList.size() > 0) {
                    Iterator<User> iterator = maxPointUserList.iterator();
                    while (iterator.hasNext()) {
                        User user1 = iterator.next();
                        if (user.getTotalPoints() > user1.getTotalPoints()) {
                            iterator.remove();
                        }
                    }
                }
                maxPointUserList.add(user);
            }
        }
        System.out.println("Query 1");
        for (User user : maxPointUserList) {
            System.out.println("Max Point User: " + user.getUsername() + " has " + user.getTotalPoints() + " points and " + user.getStreak() + " streaks");
        }
    }

    public void findMostAdvancedUserInGerman(List<User> userList) {

        int max_unit = 0;

        List<User> maxUnitUserList = new ArrayList<>();

        for (User user: userList) {
            if (user.getSelectedLanguage().getLanguageName().equals(ELanguage.GERMAN)) {
                if (user.getCurrentUnit() >= max_unit) {
                    max_unit = user.getCurrentUnit();

                    if (maxUnitUserList.size() > 0) {
                        Iterator<User> iterator = maxUnitUserList.iterator();
                        while (iterator.hasNext()) {
                            User user1 = iterator.next();
                            if (user.getCurrentUnit() > user1.getCurrentUnit()) {
                                iterator.remove();
                            }
                        }
                    }
                    maxUnitUserList.add(user);
                }
            }
        }
        System.out.println("Query 2");
        for (User user : maxUnitUserList) {
            System.out.println("Most advanced user in German: " + user.getUsername() + " has " + user.getCurrentUnit() + " units");
        }

    }

    public void findMaxUnitNumberForLanguage(List<User> userList) {

        int max_unit = 0;
        int turkishCount = 0;
        int germanCount = 0;
        int spanishCount = 0;
        int italianCount = 0;

        List<Language> languageList = new ArrayList<>();

        for (User user: userList) {
            if (user.getSelectedLanguage().getUnitList().size() >= max_unit) {

                if ((user.getSelectedLanguage().getLanguageName().equals(ELanguage.GERMAN) && (germanCount != 0) )) {
                    continue;
                } else if ((user.getSelectedLanguage().getLanguageName().equals(ELanguage.ITALIAN) && (italianCount != 0))) {
                    continue;
                } else if ((user.getSelectedLanguage().getLanguageName().equals(ELanguage.SPANISH) && (spanishCount != 0))) {
                    continue;
                } else if ((user.getSelectedLanguage().getLanguageName().equals(ELanguage.TURKISH) && (turkishCount != 0))){
                    continue;
                }


                max_unit = user.getSelectedLanguage().getUnitList().size();

                if (languageList.size() > 0) {
                    Iterator<Language> iterator = languageList.iterator();
                    while (iterator.hasNext()) {
                        Language language = iterator.next();
                        if (user.getSelectedLanguage().getUnitList().size() > language.getUnitList().size()) {
                            iterator.remove();
                        }
                    }
                }

                languageList.add(user.getSelectedLanguage());

                if (user.getSelectedLanguage().getLanguageName().equals(ELanguage.GERMAN)) {
                    germanCount++;
                } else if (user.getSelectedLanguage().getLanguageName().equals(ELanguage.ITALIAN)) {
                    italianCount++;
                } else if (user.getSelectedLanguage().getLanguageName().equals(ELanguage.SPANISH)) {
                    spanishCount++;
                } else if (user.getSelectedLanguage().getLanguageName().equals(ELanguage.TURKISH)) {
                    turkishCount++;
                }
            }

        }
        System.out.println("Query 3");
        for (Language language : languageList) {
            System.out.println("Max Unit in Language: " + language.getLanguageName() + " language has " + language.getUnitList().size() + " units");
        }

    }

    public void findMaxNumberOfQuizzesForLanguage(List<User> userList) {

        int max_quiz = 0;
        int turkishCount = 0;
        int germanCount = 0;
        int spanishCount = 0;
        int italianCount = 0;

        List<Language> languageList = new ArrayList<>();

        for (User user: userList) {
            if (user.getSelectedLanguage().getTotalQuizNumber() >= max_quiz) {
                if ((user.getSelectedLanguage().getLanguageName().equals(ELanguage.GERMAN) && (germanCount != 0) )) {
                    continue;
                } else if ((user.getSelectedLanguage().getLanguageName().equals(ELanguage.ITALIAN) && (italianCount != 0))) {
                    continue;
                } else if ((user.getSelectedLanguage().getLanguageName().equals(ELanguage.SPANISH) && (spanishCount != 0))) {
                    continue;
                } else if ((user.getSelectedLanguage().getLanguageName().equals(ELanguage.TURKISH) && (turkishCount != 0))){
                    continue;
                }

                max_quiz = user.getSelectedLanguage().getTotalQuizNumber();

                if (languageList.size() > 0) {
                    Iterator<Language> iterator = languageList.iterator();
                    while (iterator.hasNext()) {
                        Language language = iterator.next();
                        if (user.getSelectedLanguage().getTotalQuizNumber() > language.getTotalQuizNumber()) {
                            iterator.remove();
                        }
                    }
                }

                languageList.add(user.getSelectedLanguage());

                if (user.getSelectedLanguage().getLanguageName().equals(ELanguage.GERMAN)) {
                    germanCount++;
                } else if (user.getSelectedLanguage().getLanguageName().equals(ELanguage.ITALIAN)) {
                    italianCount++;
                } else if (user.getSelectedLanguage().getLanguageName().equals(ELanguage.SPANISH)) {
                    spanishCount++;
                } else if (user.getSelectedLanguage().getLanguageName().equals(ELanguage.TURKISH)) {
                    turkishCount++;
                }

            }

        }

        System.out.println("Query 4");
        for (Language language : languageList) {
            System.out.println("Max Quizzes in Language: " + language.getLanguageName() + " language has " + language.getTotalQuizNumber() + " quizzes");
        }

    }

    public void findTopThreeSilverUsersInItalianLeague(Map<ELanguage, List<League>> leagueMap) {

        System.out.println("Query 5");
        System.out.println("Top three users in the Silver league for Italian");

        for (List<League> leagues : leagueMap.values()) {
            for (League league : leagues) {
                if ((league.getLeagueName().equals(ELeagueType.SILVER) && (league.getLanguage().equals(ELanguage.ITALIAN)))) {
                    for (int i = 0 ; i < 3 ; i++) {
                        System.out.println((i + 1) + "." + league.getUserList().get(i).getUsername() + " has " + league.getUserList().get(i).getTotalPoints() + " points and " +
                                league.getUserList().get(i).getStreak() + " streaks");
                    }
                }
            }
        }

    }


}


