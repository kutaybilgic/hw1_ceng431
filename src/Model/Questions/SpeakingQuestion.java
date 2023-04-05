package Model.Questions;

import Enums.EQuestionType;
import Model.Audio;

public class SpeakingQuestion extends Question{

    private Audio audio_1;

    private Audio audio_2;

    public SpeakingQuestion(EQuestionType type, Integer questionPoint, Audio audio_1, Audio audio_2) {
        super(type, questionPoint);
        this.audio_1 = audio_1;
        this.audio_2 = audio_2;
    }

    @Override
    public boolean isCorrect() {
        return super.isCorrect();
    }

    public Audio getAudio_1() {
        return audio_1;
    }

    public void setAudio_1(Audio audio_1) {
        this.audio_1 = audio_1;
    }

    public Audio getAudio_2() {
        return audio_2;
    }

    public void setAudio_2(Audio audio_2) {
        this.audio_2 = audio_2;
    }
}
