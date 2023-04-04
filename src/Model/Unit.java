package Model;

import java.util.List;

public class Unit {

    private Integer unitNumber;

    private List<Quiz> quizList;

    public Unit(Integer unitNumber, List<Quiz> quizList) {
        this.unitNumber = unitNumber;
        this.quizList = quizList;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }
}
