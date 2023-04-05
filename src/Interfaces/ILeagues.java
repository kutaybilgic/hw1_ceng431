package Interfaces;

import Model.User;

import java.util.List;

public interface ILeagues {

    List<User> getRankings();

    void upgradeRank();
}
