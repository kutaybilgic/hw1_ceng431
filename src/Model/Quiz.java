package Model;

import Questions.Question;

import java.util.List;

public class Quiz {

    private List<Question> questionList;

    public Quiz(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
