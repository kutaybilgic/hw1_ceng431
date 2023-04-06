package Factory;

import Enums.ELanguage;
import Enums.ELeagueType;
import Enums.EQuestionType;
import Model.Language;
import Model.Questions.Question;
import Model.Questions.ReadingQuestion;
import Model.Quiz;
import Model.Unit;

import java.io.*;
import java.util.*;

public class LanguageFactory {

    public void createAllLanguage(String fileName) {

        File file = new File(fileName);

        if (file.exists()) {
            return;
        }

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
                    String printed = language.getLanguageName().toString() + ",Unit " + language.getUnitList().get(z).getUnitNumber() + "," + "Quiz " +
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

    public Language getCreatedLanguages(String pathFile, ELanguage languageType) {

        String line;
        QuestionFactory questionFactory = new QuestionFactory();
        Language createdLanguage = null;
        Random random = new Random();


        // Dil bazında verileri saklamak için bir HashMap kullanıyoruz
        Map<String, Map<String, Map<String, Map<String, int[]>>>> data = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String language = fields[0];
                String unit = fields[1];
                String quiz = fields[2];
                String result = fields[3];

                // Soru tiplerini ayrıştırıyoruz
                String[] questionTypes = result.split(":");
                int readingQuestions = Integer.parseInt(questionTypes[0].substring(0, questionTypes[0].length() - 1));
                int listeningQuestions = Integer.parseInt(questionTypes[1].substring(0, questionTypes[1].length() - 1));
                int speakingQuestions = Integer.parseInt(questionTypes[2].substring(0, questionTypes[2].length() - 1));
                int wordMatchingQuestions = Integer.parseInt(questionTypes[3].substring(0, questionTypes[3].length() - 1));

                // Dil, Unit ve Quiz seviyelerine göre verileri saklayan HashMap'leri güncelliyoruz
                if (!data.containsKey(language)) {
                    data.put(language, new LinkedHashMap<>());
                }

                if (!data.get(language).containsKey(unit)) {
                    data.get(language).put(unit, new LinkedHashMap<>());
                }

                Map<String, int[]> quizData = new LinkedHashMap<>();
                quizData.put("reading", new int[]{readingQuestions});
                quizData.put("listening", new int[]{listeningQuestions});
                quizData.put("speaking", new int[]{speakingQuestions});
                quizData.put("wordMatching", new int[]{wordMatchingQuestions});

                data.get(language).get(unit).put(quiz, quizData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        boolean isSolved = true;
        // Verileri ekrana yazdırıyoruz
        for (String language : data.keySet()) {
            if (languageType.toString().equals(language)){


            int countQuizzes = 0;
            int solvedQuizzes = 0;
            int unitNumber = 1;
            int userCurrentUnit = 0;
            int totalPoint = 0;
            //System.out.println(language);
            List<Unit> unitList = new ArrayList<>();




            for (String unit : data.get(language).keySet()) {
                //System.out.println(" - " + unit);
                countQuizzes += data.get(language).get(unit).size();

            }
            int mustSolvedQuiz = random.nextInt(6, countQuizzes);

            for (String unit: data.get(language).keySet()) {
                List<Quiz> quizList = new ArrayList<>();

                for (String quiz : data.get(language).get(unit).keySet()) {

                    if ((solvedQuizzes == mustSolvedQuiz) && isSolved) {
                        isSolved = false;
                        userCurrentUnit = unitNumber;
                    }

                    List<Question> questionList = new ArrayList<>();
                    Map<String, int[]> quizData = data.get(language).get(unit).get(quiz);
                    int[] readingQuestions = quizData.get("reading");
                    int[] listeningQuestions = quizData.get("listening");
                    int[] speakingQuestions = quizData.get("speaking");
                    int[] wordMatchingQuestions = quizData.get("wordMatching");

                    for (int i = 0 ; i < readingQuestions[0] ; i ++) {
                        Question question = questionFactory.createSpecificQuestion(EQuestionType.READING);
                        questionList.add(question);
                    }

                    for (int i = 0 ; i < listeningQuestions[0] ; i ++) {
                        Question question = questionFactory.createSpecificQuestion(EQuestionType.LISTENING);
                        questionList.add(question);
                    }

                    for (int i = 0 ; i < speakingQuestions[0] ; i ++) {
                        Question question = questionFactory.createSpecificQuestion(EQuestionType.SPEAKING);
                        questionList.add(question);
                    }

                    for (int i = 0 ; i < wordMatchingQuestions[0] ; i ++) {
                        Question question = questionFactory.createSpecificQuestion(EQuestionType.WORD_MATCHING);
                        questionList.add(question);
                    }

                    Quiz createdQuiz = new Quiz(questionList);
                    if (isSolved) {
                        for (Question question:createdQuiz.getQuestionList()) {
                            if (question.isCorrect()) {
                                createdQuiz.setQuizTotalPoint(createdQuiz.getQuizTotalPoint() + question.getQuestionPoint());
                            }
                        }
                        solvedQuizzes++;
                    }


                    totalPoint += createdQuiz.getQuizTotalPoint();
                    quizList.add(createdQuiz);

                    //System.out.println("   - " + quiz + ":");
                    //System.out.println("        - Reading: " + readingQuestions[0]);
                    //System.out.println("        - Listening: " + listeningQuestions[0]);
                    //System.out.println("        - Speaking: " + speakingQuestions[0]);
                    //System.out.println("        - Word Matching: " + wordMatchingQuestions[0]);

                }


                Unit createdUnit = new Unit(unitNumber, quizList);
                unitList.add(createdUnit);
                unitNumber ++;

            }
            createdLanguage = new Language(languageType, unitList);
            createdLanguage.setTotalQuizNumber(countQuizzes);
            createdLanguage.setCurrentUnit(userCurrentUnit);
            createdLanguage.setTotalPoint(totalPoint);
            createdLanguage.setSolvedQuizzes(solvedQuizzes);



        };
        }

        return createdLanguage;
    }
}
