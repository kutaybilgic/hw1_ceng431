package Model.Questions;

import Enums.EQuestionType;
import Util.RandomGenerator;

public class ReadingQuestion extends Question {

    private String englishText;

    private String translatedText;

    public ReadingQuestion(EQuestionType type, Integer questionPoint) {
        super(type, questionPoint);
        this.englishText = RandomGenerator.randomStringGenerator();
        this.translatedText = RandomGenerator.randomStringGenerator();
    }

    @Override
    public boolean isCorrect() {
        return super.isCorrect();
    }

    public String getEnglishText() {
        return englishText;
    }

    public void setEnglishText(String englishText) {
        this.englishText = englishText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
