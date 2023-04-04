package Questions;

import Enums.EQuestionType;
import Interfaces.IQuestions;

import java.util.Random;

public abstract class Question implements IQuestions {

    private EQuestionType type;

    private Integer questionPoint;

    public Question(EQuestionType type) {
        this.type = type;
        this.questionPoint = 0;
    }

    @Override
    public boolean isCorrect() {
        Random random = new Random();
        var intNumber = random.nextInt(0,1);

        return intNumber == 0;
    }

    public EQuestionType getType() {
        return type;
    }

    public void setType(EQuestionType type) {
        this.type = type;
    }

    public Integer getQuestionPoint() {
        return questionPoint;
    }

    public void setQuestionPoint(Integer questionPoint) {
        this.questionPoint = questionPoint;
    }
}
