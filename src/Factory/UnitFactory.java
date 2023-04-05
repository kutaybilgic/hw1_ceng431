package Factory;

import Model.Quiz;
import Model.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnitFactory {

    public Unit createUnit(Integer unitNumber) {
        Random random = new Random();
        var quizNumber = random.nextInt(1, 10);
        QuizFactory quizFactory = new QuizFactory();
        List<Quiz> quizList = new ArrayList<>();

        for (int i = 0 ; i < quizNumber ; i++) {
            Quiz quiz = quizFactory.createQuiz();
            quizList.add(quiz);
        }


        return new Unit(unitNumber, quizList);
    }
}
