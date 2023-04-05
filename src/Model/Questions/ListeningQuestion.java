package Model.Questions;

import Enums.EQuestionType;
import Interfaces.IQuestions;
import Model.Audio;

public class ListeningQuestion extends Question implements IQuestions {

    private String listeningWord;

    private Audio listeningAudio;

    public ListeningQuestion(EQuestionType type, Integer questionPoint, String listeningWord, Audio listeningAudio) {
        super(type, questionPoint);
        this.listeningWord = listeningWord;
        this.listeningAudio = listeningAudio;
    }

    @Override
    public boolean isCorrect() {
        return super.isCorrect();
    }

    public String getListeningWord() {
        return listeningWord;
    }

    public void setListeningWord(String listeningWord) {
        this.listeningWord = listeningWord;
    }

    public Audio getListeningAudio() {
        return listeningAudio;
    }

    public void setListeningAudio(Audio listeningAudio) {
        this.listeningAudio = listeningAudio;
    }
}
