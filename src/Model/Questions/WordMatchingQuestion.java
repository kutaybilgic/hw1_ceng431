package Model.Questions;

import Enums.EQuestionType;

import java.util.Map;

public class WordMatchingQuestion extends Question{

    private Map<String, String> matching;

    public WordMatchingQuestion(EQuestionType type, Integer questionPoint ,Map<String, String> matching) {
        super(type, questionPoint);
        this.matching = matching;
    }

    @Override
    public boolean isCorrect() {
        return super.isCorrect();
    }

    public Map<String, String> getMatching() {
        return matching;
    }

    public void setMatching(Map<String, String> matching) {
        this.matching = matching;
    }


}
