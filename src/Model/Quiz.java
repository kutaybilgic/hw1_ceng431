package Model;

import Model.Questions.Question;

import java.util.List;

public class Quiz {

    private List<Question> questionList;

    private Integer quizTotalPoint;

    public Quiz(List<Question> questionList) {
        this.questionList = questionList;
        this.quizTotalPoint = 0;
    }

    public Integer getQuizTotalPoint() {
        return quizTotalPoint;
    }

    public void setQuizTotalPoint(Integer quizTotalPoint) {
        this.quizTotalPoint = quizTotalPoint;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
