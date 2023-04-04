package Factory;

import Model.Quiz;
import Questions.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizFactory {

    public Quiz createQuiz() {
        QuestionFactory questionFactory = new QuestionFactory();
        Random random = new Random();
        var questionNumber = random.nextInt(8, 15);
        List<Question> questionList = new ArrayList<>();

        for (int i = 0 ; i < questionNumber ; i++) {
            Question  question = questionFactory.createQuestion();
            questionList.add(question);
        }

        return new Quiz(questionList);
    }
}
