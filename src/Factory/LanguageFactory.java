package Factory;

import Enums.ELanguage;
import Enums.EQuestionType;
import Model.Language;
import Model.Unit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LanguageFactory {

    public void createAllLanguage() {

        Random random = new Random();
        ELanguage[] languagesType = ELanguage.values();
        List<Unit> unitList = new ArrayList<>();
        UnitFactory unitFactory = new UnitFactory();

        int R = 0;
        int L = 0;
        int S = 0;
        int W = 0;

        List<String> writerCsv = new ArrayList<>();

        for (int i = 0 ; i < 4 ; i++) {
            var unitNumber = random.nextInt(60, 100);
            for (int x = 0 ; x < unitNumber ; x++){
                Unit unit = unitFactory.createUnit(x + 1);
                unitList.add(unit);
            }
            var language = new Language(languagesType[i], unitList);

            for (int z = 0; z < language.getUnitList().size(); z++) {
                var quizCount = language.getUnitList().get(z).getQuizList().size();
                for (int y = 0 ; y < quizCount; y++) {
                    var questionCount = language.getUnitList().get(z).getQuizList().get(y).getQuestionList().size();
                    for (int k = 0 ; k < questionCount; k++){

                        if (language.getUnitList().get(z).getQuizList().get(y).getQuestionList().get(k).getType().equals(EQuestionType.LISTENING)) {
                            L++;
                        }
                        else if (language.getUnitList().get(z).getQuizList().get(y).getQuestionList().get(k).getType().equals(EQuestionType.READING)) {
                            R++;
                        }
                        else if (language.getUnitList().get(z).getQuizList().get(y).getQuestionList().get(k).getType().equals(EQuestionType.SPEAKING)) {
                            S++;
                        }
                        else{
                            W++;
                        }
                    }
                    String printed = language.getLanguageName().toString() + " Unit " + language.getUnitList().get(z).getUnitNumber() + "," + " Quiz " +
                            (y + 1) + "," + R + "R" + ":" + L + "L" + ":" + S + "S" + ":" + W + "W";
                    writerCsv.add(printed);
                    R = 0;
                    L = 0;
                    S = 0;
                    W = 0;

                }
            }

            unitList.clear();

        }
        String fileName = "languages.csv";
        File file = new File(fileName);

        if (file.exists()) {
            return;
        }

        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < writerCsv.size() - 1; i++) {
                fileWriter.write(writerCsv.get(i) + "\n");
            }

            fileWriter.write(writerCsv.get(writerCsv.size() - 1));

            fileWriter.close();
            System.out.println("Content was written to a new file " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while creating or writing to the file " + fileName);
            e.printStackTrace();
        }




    }
}
