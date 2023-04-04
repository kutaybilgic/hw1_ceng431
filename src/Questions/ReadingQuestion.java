package Questions;

import Enums.EQuestionType;

public class ReadingQuestion extends Question {

    private String englishText;

    private String translatedText;

    public ReadingQuestion(EQuestionType type, String englishText, String translatedText) {
        super(type);
        this.englishText = englishText;
        this.translatedText = translatedText;
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
