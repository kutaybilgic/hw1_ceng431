package Factory;

import Enums.EQuestionType;
import Model.Questions.*;

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
            case READING -> question = new ReadingQuestion(randomType, 10, "text", "translatedText");
            case LISTENING -> question = new ListeningQuestion(randomType, 7,"listeningWord", audioFactory.createAudio());
            case SPEAKING ->
                    question = new SpeakingQuestion(randomType, 8, audioFactory.createAudio(), audioFactory.createAudio());
            case WORD_MATCHING -> {
                var mapNumber = random.nextInt(4, 8);
                Map<String, String> mapMatching = new HashMap<>();
                for (int i = 0; i < mapNumber; i++) {
                    mapMatching.put("key", "value");
                }
                question = new WordMatchingQuestion(randomType, 5, mapMatching);
            }
        }

        return question;
    }

    public Question createSpecificQuestion(EQuestionType type) {
        Random random = new Random();
        Question question = null;
        AudioFactory audioFactory = new AudioFactory();

        switch (type) {
            case READING -> question = new ReadingQuestion(type, 10, "text", "translatedText");
            case LISTENING -> question = new ListeningQuestion(type, 7,"listeningWord", audioFactory.createAudio());
            case SPEAKING ->
                    question = new SpeakingQuestion(type, 8, audioFactory.createAudio(), audioFactory.createAudio());
            case WORD_MATCHING -> {
                var mapNumber = random.nextInt(4, 8);
                Map<String, String> mapMatching = new HashMap<>();
                for (int i = 0; i < mapNumber; i++) {
                    mapMatching.put("key", "value");
                }
                question = new WordMatchingQuestion(type, 5, mapMatching);
            }
        }

        return question;
    }

}
