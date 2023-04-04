package Factory;

import Enums.EQuestionType;
import Model.Audio;
import Questions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuestionFactory {

    public Question createQuestion() {
        Random random = new Random();
        EQuestionType[] questionTypes = EQuestionType.values();
        EQuestionType randomType = questionTypes[random.nextInt(questionTypes.length)];
        Question question = null;
        AudioFactory audioFactory = new AudioFactory();

        switch (randomType) {
            case READING -> question = new ReadingQuestion(randomType, "text", "translatedText");
            case LISTENING -> question = new ListeningQuestion(randomType, "listeningWord", audioFactory.createAudio());
            case SPEAKING ->
                    question = new SpeakingQuestion(randomType, audioFactory.createAudio(), audioFactory.createAudio());
            case WORD_MATCHING -> {
                var mapNumber = random.nextInt(4, 8);
                Map<String, String> mapMatching = new HashMap<>();
                for (int i = 0; i < mapNumber; i++) {
                    mapMatching.put("key", "value");
                }
                question = new WordMatchingQuestion(randomType, mapMatching);
            }
        }

        return question;



    }
}
